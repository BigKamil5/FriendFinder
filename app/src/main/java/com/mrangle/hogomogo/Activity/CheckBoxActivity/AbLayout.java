package com.mrangle.hogomogo.Activity.CheckBoxActivity;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;

import com.mrangle.hogomogo.Class.ExtensionClass.MyDialogFragment;
import com.mrangle.hogomogo.R;

public abstract class AbLayout extends AppCompatActivity {

    public Button button;



    public CheckBox[][] checkBoxes ;





    protected ScrollView scrollView;
    protected ConstraintLayout bodyOfLayout;
    protected ConstraintLayout upOfLayout;
    protected ConstraintLayout downOfLayout;
    protected Button buttonGotowe;
    protected Button buttonWroc;




    protected DialogFragment messagebox = new MyDialogFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.define_checkboxes_abstract_layout);

        buttonGotowe                = findViewById(R.id.buttonGotowe);
        buttonWroc                  = findViewById(R.id.buttonWroc);

        checkBoxes = new CheckBox[][]{
                //Gatunek//
            {findViewById(R.id.checkPies),          findViewById(R.id.checkKot),        findViewById(R.id.checkInne)},
            {findViewById(R.id.checkDlugie),        findViewById(R.id.checkSrednie),    findViewById(R.id.checkKrotkie),        findViewById(R.id.checkBrak)},
            {findViewById(R.id.checkAkWysoka),      findViewById(R.id.checkAkSrednia),  findViewById(R.id.checkAkNiska)},
            {findViewById(R.id.checkRuWysoka),      findViewById(R.id.checkRuSrednia),  findViewById(R.id.checkRuNiska)},
            {findViewById(R.id.checkCzPrzyjazne),   findViewById(R.id.checkCzObojetne), findViewById(R.id.checkCzAgresywne)},
            {findViewById(R.id.checkDzPrzyjazne),   findViewById(R.id.checkDzObojetne), findViewById(R.id.checkDzAgresywne)},
            {findViewById(R.id.checkZwPrzyjazne),   findViewById(R.id.checkZwObojetne), findViewById(R.id.checkZwAgresywne)},
            {findViewById(R.id.checkNiWysoka),      findViewById(R.id.checkNiSrednia),  findViewById(R.id.checkNiNiska)},
            {findViewById(R.id.checkUczWysoki),     findViewById(R.id.checkUczSredni),  findViewById(R.id.checkUczNiski)},
        };

    }

}

