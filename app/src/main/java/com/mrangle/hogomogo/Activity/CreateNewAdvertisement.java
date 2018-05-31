package com.mrangle.hogomogo.Activity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrangle.hogomogo.InputFilterMinMax;
import com.mrangle.hogomogo.Pet;
import com.mrangle.hogomogo.R;

public class CreateNewAdvertisement extends AbLayout {

    protected EditText ed_choroby;
    protected EditText ed_opis;
    protected EditText ed_imie;
    protected EditText ed_wiek;
    protected EditText ed_koszt;

    protected Button button;

    protected Pet newPet;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final LayoutInflater factory = getLayoutInflater();

        final View textEntryView = factory.inflate(R.layout.activity_create_new_advertisement, null);

        upOfLayout          = findViewById(R.id.AbTopLayout);
        downOfLayout        = findViewById(R.id.AbBottomLayout);

        newPet = new Pet();
        //Gatunek
        /*
        Ogolny sposob przypisywania wartosci, wiersz okresla ceche, a kolumna konkretny atrybut
        Przykładowe określanie Gatunku:

        INDEX ATRYBUTU W TABLICY CHECKBOXOW JEST O 1 MNIEJSZY NIZ W PET
        TODO: Usprawnic index atrybutu, aby nie trzeba było odejmować 1 od stałej

         */
        //Przykładowe uzycie
        checkBoxes[Pet.GATUNEK][Pet.PIES-1].setOnClickListener(new MyOnClickListener(Pet.GATUNEK, Pet.PIES)); // tez fajny sposob (View v) -> { checkSetPies(v);
        checkBoxes[Pet.GATUNEK][Pet.KOT-1].setOnClickListener(new MyOnClickListener(Pet.GATUNEK, Pet.KOT));
        checkBoxes[Pet.GATUNEK][Pet.INNE-1].setOnClickListener(new MyOnClickListener(Pet.GATUNEK, Pet.INNE));

        /*
        Zdefiniowanie wszystkich checkboxow
         */
        for(int cecha = 1; cecha < checkBoxes.length; cecha++)
            for(int atrybut = 0; atrybut < checkBoxes[cecha].length; atrybut++)
                checkBoxes[cecha][atrybut].setOnClickListener(new MyOnClickListener(cecha, atrybut+1));

        ConstraintLayout topLayout = textEntryView.findViewById(R.id.TopLayout );
        ConstraintLayout bottomLayout = textEntryView.findViewById(R.id.BottomLayout );

        //ConstraintLayout placeHolder =  findViewByid(R.id.layout);



        ed_choroby          = textEntryView.findViewById(R.id.editChoroby );
        ed_opis             = textEntryView.findViewById(R.id.editOpis);
        ed_imie             = textEntryView.findViewById(R.id.editImie    );
        ed_wiek             = textEntryView.findViewById(R.id.editWiek    );
        ed_koszt            = textEntryView.findViewById(R.id.editKoszt);

        ed_wiek.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        ed_koszt.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "1000000")});

        button              = textEntryView.findViewById(R.id.buttonGotowe);

        TextView textKoszt = textEntryView.findViewById(R.id.textKoszt);
        TextView textChoroby = textEntryView.findViewById(R.id.textChoroby);
        TextView textOpis = textEntryView.findViewById(R.id.textOpis);


        ((ViewGroup)topLayout.getParent()).removeAllViews();
        ((ViewGroup)textKoszt.getParent()).removeAllViews();

        //downOfLayout.addView(bottomLayout);
        upOfLayout.addView(topLayout);
        //upOfLayout.addView(ed_wiek);


        /* z jakiegos powodu nie działa downOfLayout.addView(bottomLayout);
        * TODO: Znalezc powod czemu nie dziala i trzeba recznie wszystkie dodawac
        * */

        downOfLayout.addView(textKoszt);
        downOfLayout.addView(ed_koszt);
        downOfLayout.addView(textChoroby);
        downOfLayout.addView(ed_choroby);
        downOfLayout.addView(textOpis);
        downOfLayout.addView(ed_opis);
        downOfLayout.addView(button);




    }

    public void clickGotowe(View v)
    {
        if(!ed_choroby.getText().toString().matches(""))    newPet.setChorobyOrazProblemy(ed_choroby.getText().toString());
        if(!ed_opis.getText().toString().matches(""))       newPet.setOpis(ed_opis.getText().toString());
        if(!ed_imie.getText().toString().matches(""))       newPet.setImie(ed_imie.getText().toString());
        if(!ed_wiek.getText().toString().matches(""))       newPet.setWiek(Integer.parseInt(ed_wiek.getText().toString()));
        if(!ed_koszt.getText().toString().matches(""))      newPet.setMiesiecznyKosztUtrzymania(Integer.parseInt(ed_koszt.getText().toString()));

        Intent intent = new Intent(this, activity_show_advertisement.class).putExtra("Pet", newPet);

        startActivity(intent);

        finish();
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
                newPet.id_atrybuty[cecha] = Pet.BRAK_INFORMACJI;
            else
                newPet.id_atrybuty[cecha] = atrybut;


            /* ustawia reszte checkboxow z danej rodziny na false */
            for(int i = 0; i < checkBoxes[cecha].length; i++ ) {
                if (i != atrybut - 1)
                    checkBoxes[cecha][i].setChecked(false);
            }
        }
    }



}
