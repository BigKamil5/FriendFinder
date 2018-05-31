package com.mrangle.hogomogo.Activity;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mrangle.hogomogo.MyDialogFragment;
import com.mrangle.hogomogo.Pet;
import com.mrangle.hogomogo.R;

public class activity_show_advertisement extends AppCompatActivity {

    Pet pet;
    private DialogFragment messagebox = new MyDialogFragment();

    /* PRZECHOWUJE WARTOSCI CECH */
    TextView[] textViewTable;

    TextView textImie;
    TextView textWiek;

    TextView textKoszt;
    TextView textChoroby;
    TextView textOpis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_advertisement);

        pet = (Pet) getIntent().getSerializableExtra("Pet");


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

        textKoszt                       = findViewById(R.id.petKoszt);
        textChoroby                     = findViewById(R.id.petChoroby);
        textOpis                        = findViewById(R.id.petOpis);

        getInformationAboutPet();




    }

    @SuppressLint("SetTextI18n")
    public void getInformationAboutPet()
    {


        textImie                        .setText(pet.getImie());
        textWiek                        .setText(pet.getWiek() + "");
        for(int cecha = 0; cecha < textViewTable.length; cecha++)
            textViewTable[cecha].setText(Pet.zbiorCech[cecha][pet.id_atrybuty[cecha]]);

        //textGatunek                     .setText(Pet.zbiorCech[Pet.GATUNEK][pet.id_atrybuty[Pet.GATUNEK]]);
        //textDlugoscSiersci              .setText(Pet.kryterium[Pet.dlugoscSiersci][pet.id_atrybuty[Pet.dlugoscSiersci]]);
        /*textZapotrzebowanieNaAktywnosc  .setText(pet.zapotrzebowanieNaAktywnosc.toString());
        textRuchliwosc                  .setText(pet.ruchliwosc.toString());
        textNastawienieDoCzlowieka      .setText(pet.nastawienieDoCzlowieka.toString());
        textNastawienieDoDzieci         .setText(pet.nastawienieDoDzieci.toString());
        textNastawienieDoInnychZwierzat .setText(pet.nastawienieDoInnychZwierzat.toString());
        textSklonnosciDoNiszczenia      .setText(pet.sklonnosciDoNiszczenia.toString());
        textStopenUczulania             .setText(pet.stopienUczulania.toString());*/
        textKoszt                       .setText(pet.getMiesiecznyKosztUtrzymania() + "");
        textChoroby                     .setText(pet.getChorobyOrazProblemy());
        textOpis                        .setText(pet.getOpis());
    }

    public void clickGotowe(View v)
    {
        setContentView(R.layout.activity_menu);
        finish();
    }

        //messagebox.show(this.getFragmentManager(), pet.getChorobyOrazProblemy());



}
