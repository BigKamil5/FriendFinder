package com.mrangle.hogomogo.Activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrangle.hogomogo.MyDialogFragment;
import com.mrangle.hogomogo.Pet;
import com.mrangle.hogomogo.R;

public abstract class AbLayout extends AppCompatActivity {

    public Button button;



    public CheckBox[][] checkBoxes ;





    protected ScrollView scrollView;
    protected ConstraintLayout bodyOfLayout;
    protected ConstraintLayout upOfLayout;
    protected ConstraintLayout downOfLayout;



    protected DialogFragment messagebox = new MyDialogFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advertisement);

        checkBoxes = new CheckBox[][]{
                //Gatunek//
                {findViewById(R.id.checkPies), findViewById(R.id.checkKot), findViewById(R.id.checkInne)},
                {findViewById(R.id.checkDlugie), findViewById(R.id.checkSrednie), findViewById(R.id.checkKrotkie), findViewById(R.id.checkBrak)},
                {findViewById(R.id.checkAkWysoka), findViewById(R.id.checkAkSrednia), findViewById(R.id.checkAkNiska)},
                {findViewById(R.id.checkRuWysoka), findViewById(R.id.checkRuSrednia), findViewById(R.id.checkRuNiska)},
                {findViewById(R.id.checkCzPrzyjazne), findViewById(R.id.checkCzObojetne), findViewById(R.id.checkCzAgresywne)},
                {findViewById(R.id.checkDzPrzyjazne), findViewById(R.id.checkDzObojetne), findViewById(R.id.checkDzAgresywne)},
                {findViewById(R.id.checkZwPrzyjazne), findViewById(R.id.checkZwObojetne), findViewById(R.id.checkZwAgresywne)},
                {findViewById(R.id.checkNiWysoka), findViewById(R.id.checkNiSrednia), findViewById(R.id.checkNiNiska)},
                {findViewById(R.id.checkUczWysoki), findViewById(R.id.checkUczSredni), findViewById(R.id.checkUczNiski)},
        };










    }





}

/*
protected CheckBox checkPies;
    protected CheckBox checkKot;
    protected CheckBox checkInne;

    //Dlugosc siersci
    protected CheckBox checkDlugie;
    protected CheckBox checkSrednie;
    protected CheckBox checkKrotkie;
    protected CheckBox checkBrak;

    //Aktywnosc//
    protected CheckBox checkAkWysoka;
    protected CheckBox checkAkSrednia;
    protected CheckBox checkAkNiska;

    //Ruchliwosc
    protected CheckBox checkRuWysoka;
    protected CheckBox checkRuSrednia;
    protected CheckBox checkRuNiska;

    //Nastawienie do czlowieka
    protected CheckBox checkCzPrzyjazne;
    protected CheckBox checkCzObojetne;
    protected CheckBox checkCzAgresywne;

    //Nastawienie do dzieci
    protected CheckBox checkDzPrzyjazne;
    protected CheckBox checkDzObojetne;
    protected CheckBox checkDzAgresywne;

    //Nastawienie do innych zwierzat
    protected CheckBox checkZwPrzyjazne;
    protected CheckBox checkZwObojetne;
    protected CheckBox checkZwAgresywne;

    //Slonnosc do niszczenia
    protected CheckBox checkNiWysoka;
    protected CheckBox checkNiSrednia;
    protected CheckBox checkNiNiska;

    //stopien uczulania
    protected CheckBox checkUczWysoki;
    protected CheckBox checkUczSredni;
    protected CheckBox checkUczNiski;
 */
