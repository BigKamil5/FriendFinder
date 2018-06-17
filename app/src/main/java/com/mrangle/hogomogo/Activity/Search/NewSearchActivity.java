package com.mrangle.hogomogo.Activity.Search;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrangle.hogomogo.Class.ExtensionClass.MyDialogFragment;
import com.mrangle.hogomogo.Class.Globals;
import com.mrangle.hogomogo.Class.Pet;
import com.mrangle.hogomogo.Class.PhotoEditor;
import com.mrangle.hogomogo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NewSearchActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private ConstraintSet   constraintSetOld = new ConstraintSet();
    private ConstraintSet   constraintSetNew = new ConstraintSet();
    private boolean altLayout;

    protected static final int REQUEST_EXIT = 2;

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

    protected Button btnAccept;

    protected ProgressBar loading;

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



    @SuppressLint("SetTextI18n")
    public void getInformationAboutPet(){

        textImie                        .setText(pet.getImie());
        textWiek                        .setText((pet.getWiek() != -1 ? pet.getWiek() : "Brak informacji")  + "");

        for(int cecha = 0; cecha < textViewTable.length; cecha++)
            textViewTable[cecha].setText(Pet.zbiorCech[cecha][pet.id_atrybuty[cecha]]);

        textKoszt                       .setText((pet.getMiesiecznyKosztUtrzymania() != -1 ? pet.getMiesiecznyKosztUtrzymania() : "Brak informacji") + "");
        textChoroby                     .setText(pet.getChorobyOrazProblemy());
        textOpis                        .setText(pet.getOpis());

        Uri uri = Uri.parse(pet.stringUriImage);

        try {

            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            PhotoEditor.setImage(imageView, bitmap, uri, getApplicationContext());
        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
    public void SendToServer()
    {
        //TODO wysyłanie do serwera i tworzenie selekcikow
        loading.setVisibility(View.VISIBLE);
        btnAccept.setVisibility(View.GONE);

        final String ID = Integer.toString(this.pet.getId()).trim();
        final String Type = Integer.toString(this.pet.id_atrybuty[Pet.GATUNEK]).trim();
        final String LengthOfHair = Integer.toString(this.pet.id_atrybuty[Pet.DLUGOSCSIERSCI]).trim();
        final String TheNeedForActivity = Integer.toString(this.pet.id_atrybuty[Pet.ZAPOTRZEBOWANIE_NA_AKTYWNOSC]).trim();
        final String Ruchliwosc = Integer.toString(this.pet.id_atrybuty[Pet.RUCHLIWOSC]).trim();

        Toast.makeText(NewSearchActivity.this, (ID + Type + LengthOfHair + TheNeedForActivity), Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Globals.URL_ADD_PET,
                response -> {
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");

                        if (success.equals("1")) {
                            Toast.makeText(NewSearchActivity.this, "Pet has beed added - Success!", Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                            btnAccept.setVisibility(View.VISIBLE);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(NewSearchActivity.this, "Error! " + e.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btnAccept.setVisibility(View.VISIBLE);
                    }
                },
                error -> {
                    Toast.makeText(NewSearchActivity.this, "Error! " + error.toString(), Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    btnAccept.setVisibility(View.VISIBLE);
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("ID", ID);
                params.put("Type", Type);
                params.put("LengthOfHair", LengthOfHair);
                params.put("TheNeedForActivity",TheNeedForActivity);
                params.put("Ruchliwosc", Ruchliwosc);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    } */



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

    /*public void clickGotowe(View v)
    {
        SendToServer();                         // wysylanie do bazy danych
        setResult(REQUEST_EXIT, null);
        finish();
    }*/

    public void backToMenu(View v)
    {
        finish();
    }
}
