package com.mrangle.hogomogo.Activity.StareDoNaukiAlboSprawdzania;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrangle.hogomogo.Class.ExtensionClass.MyDialogFragment;
import com.mrangle.hogomogo.Class.Pet;
import com.mrangle.hogomogo.Class.PhotoEditor;
import com.mrangle.hogomogo.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowAdvertisementOld extends AppCompatActivity {

    private static final int REQUEST_EXIT = 2;

    private Pet pet;
    private DialogFragment messagebox = new MyDialogFragment();

    /* PRZECHOWUJE WARTOSCI CECH */
    TextView[] textViewTable;

    TextView textImie;
    TextView textWiek;

    TextView textKoszt;
    TextView textChoroby;
    TextView textOpis;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_advertisement);

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

    public void SendToServer()
    {
        //TODO wysyłanie do serwera i tworzenie selekcikow
    }

    public void clickGotowe(View v)
    {
        SendToServer();                         // wysylanie do bazy danych
        setResult(REQUEST_EXIT, null);          // konczy działanie CreateNewAdvertisement
        setContentView(R.layout.menu_layout); // wraca do menu
        finish();
    }

        //
    public void backToEditMenu(View v)
    {
        setContentView(R.layout.content_create_new_advertisement);
        finish();
    }


}
