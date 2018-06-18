package com.mrangle.hogomogo.Activity.Search;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrangle.hogomogo.Activity.LoginAndRegister.HomeActivity;
import com.mrangle.hogomogo.Activity.MenuActivity;
import com.mrangle.hogomogo.Class.ExtensionClass.MyDialogFragment;
import com.mrangle.hogomogo.Class.Globals;
import com.mrangle.hogomogo.Class.Pet;
import com.mrangle.hogomogo.Class.PhotoEditor;
import com.mrangle.hogomogo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NewSearchActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private ConstraintSet   constraintSetOld = new ConstraintSet();
    private ConstraintSet   constraintSetNew = new ConstraintSet();
    private boolean altLayout;

    protected static final int REQUEST_EXIT = 2;
    private final int REQUEST_WRITE_PERMISSION = 200;

    protected Pet pet;
    protected DialogFragment messagebox = new MyDialogFragment();

    /* PRZECHOWUJE WARTOSCI CECH */
    TextView[] textViewTable;

    TextView textImie;
    TextView textWiek;

    TextView textKoszt;
    TextView textChoroby;
    TextView textOpis;

    ImageView imageView;

    private File storageDirectory;

    protected Button btnAccept;

    protected ProgressBar loading;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_advertisement_new);

        btnAccept = findViewById(R.id.buttonGotowe);
        //btnAccept.setOnClickListener(this::clickGotowe);
        
        layout = findViewById(R.id.layout);
        loading = findViewById(R.id.loading);
        constraintSetOld.clone(layout);
        constraintSetNew.clone(this,R.layout.search_adverisement_new_alt);


        try {
            pet = (Pet) getIntent().getSerializableExtra("Pet");
        }
        catch (Exception NullPointerException)
        {
            this.finish();
        }

        textImie                        = findViewById(R.id.petImie);
        textWiek                        = findViewById(R.id.petWiek);

        /*  */
        textViewTable = new TextView[]{
                //Gatunek//
                findViewById(R.id.petGatunek),
                findViewById(R.id.petDlugoscSiersci),
                findViewById(R.id.petAktywnosc),
                findViewById(R.id.petRuchliwosc),
                findViewById(R.id.petNastawienieDoCzlowieka),
                findViewById(R.id.petNastawienieDoDzieci),
                findViewById(R.id.petNastawienieDoInnychZwierzat),
                findViewById(R.id.petSlonnoscDoNiszczenia),
                findViewById(R.id.petStopienUczulania)
        };

        textKoszt                       = findViewById(R.id.petKoszt );
        textChoroby                     = findViewById(R.id.petChoroby);
        textOpis                        = findViewById(R.id.petOpis);

        imageView                       = findViewById(R.id.imageView);


        getInformationAboutPet();
    }






    @SuppressLint({"SetTextI18n"})
    public void getInformationAboutPet(){

        textImie                        .setText(pet.getImie());
        textWiek                        .setText((pet.getWiek() != -1 ? pet.getWiek() : "Brak informacji")  + "");

        for(int cecha = 0; cecha < textViewTable.length; cecha++)
            textViewTable[cecha].setText(Pet.zbiorCech[cecha][pet.id_atrybuty[cecha]]);

        textKoszt                       .setText((pet.getMiesiecznyKosztUtrzymania() != -1 ? pet.getMiesiecznyKosztUtrzymania() : "Brak informacji") + "");
        textChoroby                     .setText(pet.getChorobyOrazProblemy());
        textOpis                        .setText(pet.getOpis());

        //pet.stringUriImage = "test";
        Uri uri = Uri.parse(pet.stringUriImage);

        try {

            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            //pet.stringUriImage = getStringImage(bitmap);
            PhotoEditor.setImage(imageView, bitmap, uri, getApplicationContext());
        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_WRITE_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(NewSearchActivity.this, "Sorry!!!, you can't use this app without granting this permission", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void swapViews(View v)
    {

        Transition changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new OvershootInterpolator());

        TransitionManager.beginDelayedTransition(layout, changeBounds);

        if(!altLayout)
        {
            constraintSetNew.applyTo(layout);
            altLayout = true;
        }
        else
        {
            constraintSetOld.applyTo(layout);
            altLayout = false;
        }
    }


    public void backToMenu(View v)
    {
        finish();
    }



}
