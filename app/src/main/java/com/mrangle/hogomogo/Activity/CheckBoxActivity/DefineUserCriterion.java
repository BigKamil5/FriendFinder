package com.mrangle.hogomogo.Activity.CheckBoxActivity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.mrangle.hogomogo.Class.ExtensionClass.InputFilterMinMax;
import com.mrangle.hogomogo.Class.Pet;
import com.mrangle.hogomogo.R;
import com.mrangle.hogomogo.Class.UserData;

public class DefineUserCriterion extends AbLayout {

    private static final int CHECKBOX_DIFFERENCE = 1;

    EditText ed_OdWiek ;
    EditText ed_DoWiek ;
    EditText ed_OdKoszt;
    EditText ed_DoKoszt;
    //UserData newUserData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LayoutInflater factory = getLayoutInflater();
        final View textEntryView = factory.inflate(R.layout.define_user_criterion, null);



        /* ustawia checkboxy odpowiedzialne za ustawienie danych uzytkownika */
        for(int cecha = 0; cecha < checkBoxes.length; cecha++)
            for(int atrybut = 1; atrybut < checkBoxes[cecha].length + CHECKBOX_DIFFERENCE; atrybut++)
                checkBoxes[cecha][atrybut - CHECKBOX_DIFFERENCE].setOnClickListener(new MyOnClickListener(cecha, atrybut));

        ConstraintLayout headLayout = textEntryView.findViewById(R.id.HeadLayout);

        upOfLayout          = findViewById(R.id.AbTopLayout);
        downOfLayout        = findViewById(R.id.AbBottomLayout);

        ed_OdWiek           = textEntryView.findViewById(R.id.editOdWiek);
        ed_DoWiek           = textEntryView.findViewById(R.id.editDoWiek);
        ed_OdKoszt          = textEntryView.findViewById(R.id.editOdKoszt);
        ed_DoKoszt          = textEntryView.findViewById(R.id.editDoKoszt);

        ed_OdWiek           .setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        ed_DoWiek           .setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        ed_OdKoszt          .setFilters(new InputFilter[]{ new InputFilterMinMax("0", "999999")});
        ed_DoKoszt          .setFilters(new InputFilter[]{ new InputFilterMinMax("0", "999999")});

        /* Kasowanie przydzielenie do konkretnego layoutu */
        ((ViewGroup)headLayout.getParent()).removeAllViews();

        buttonGotowe        .setOnClickListener(this::clickGotowe);
        buttonWroc          .setOnClickListener(this::backToMenu);

        upOfLayout.addView(headLayout);

        /* ustawia dane zalogowanego uzytkownika */
        setUserData();


        /*downOfLayout.addView(textKoszt);
        downOfLayout.addView(ed_koszt);
        downOfLayout.addView(textChoroby);
        downOfLayout.addView(ed_choroby);
        downOfLayout.addView(textOpis);
        downOfLayout.addView(ed_opis);*/
        //downOfLayout.addView(button);

    }

    public void clickGotowe(View v)
    {
        safe();

        //TODO Wysylanie danych do serwera

        finish();
    }

    public void backToMenu(View v)
    {
        finish();
    }

    private void safe()
    {
        UserData.wiek[UserData.MIN]     = Integer.parseInt(ed_OdWiek.getText().toString());
        UserData.wiek[UserData.MAX]     = Integer.parseInt(ed_DoWiek.getText().toString());

        UserData.koszt[UserData.MIN]    = Integer.parseInt(ed_OdKoszt.getText().toString());
        UserData.koszt[UserData.MAX]    = Integer.parseInt(ed_DoKoszt.getText().toString());
    }

    /* Moj clickListener, zeby moc sprecyzowac konkretny zbior cech i atrybut */
    private class MyOnClickListener implements View.OnClickListener
    {

        int cecha;
        int atrybut;

        public MyOnClickListener(int cecha, int atrybut)
        {
            this.cecha = cecha;
            this.atrybut = atrybut;
        }
        /*
            Definiowanie cech nastepuje dynamicznie. Wraz z kliknieciem danego Checkboxa
            nastepuje przydzielenie konkretnej cechy do tworzonego zwierzecia
         */
        @Override
        public void onClick(View v)
        {
            /* jesli odznaczono dany checkbox to cecha ustawiana na BRAK_INFORMACJI */
            if(!((CheckBox)v).isChecked())
                UserData.kryterium[cecha][Pet.BRAK_INFORMACJI]   = true;
            else {
                UserData.kryterium[cecha][atrybut]               = true;
                UserData.kryterium[cecha][Pet.BRAK_INFORMACJI]   = false;
            }

        }
    }

    private void setUserData()
    {
        for(int cecha = 0; cecha < checkBoxes.length; cecha++)
            for(int atrybut = 1; atrybut < checkBoxes[cecha].length + CHECKBOX_DIFFERENCE; atrybut++)
                if(UserData.kryterium[cecha][atrybut])
                    checkBoxes[cecha][atrybut - CHECKBOX_DIFFERENCE].setChecked(true);

        try {
            ed_OdWiek.setText(String.valueOf(UserData.wiek[UserData.MIN]));
            ed_DoWiek.setText(String.valueOf(UserData.wiek[UserData.MAX]));

            ed_OdKoszt.setText(String.valueOf(UserData.koszt[UserData.MIN]));
            ed_DoKoszt.setText(String.valueOf(UserData.koszt[UserData.MAX]));
        }
        catch(Exception ignored){ }

    }


}
