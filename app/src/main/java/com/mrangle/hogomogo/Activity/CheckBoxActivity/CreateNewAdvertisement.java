package com.mrangle.hogomogo.Activity.CheckBoxActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrangle.hogomogo.Activity.Search.SendDataAboutNewPet;
import com.mrangle.hogomogo.Class.ExtensionClass.InputFilterMinMax;
import com.mrangle.hogomogo.Class.ExtensionClass.MyDialogFragment;
import com.mrangle.hogomogo.Class.Pet;
import com.mrangle.hogomogo.Class.PhotoEditor;
import com.mrangle.hogomogo.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateNewAdvertisement extends AbLayout {

    private static final int GET_FROM_GALLERY = 3;
    private static final int REQUEST_EXIT = 2;
    private static final int RESULT_LOAD_IMAGE = 1;
    protected EditText ed_choroby;
    protected EditText ed_opis;
    protected EditText ed_imie;
    protected EditText ed_wiek;
    protected EditText ed_koszt;

    ImageView imageView;

    protected Button buttonImage;

    protected Pet newPet;

    Context context ;
    Placeholder placek;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        newPet = new Pet();
        /*if(((newPet = (Pet) getIntent().getSerializableExtra("Pet")) == null))
        {
            newPet = new Pet();
        }
        else
        {
            for(int cecha = 0; cecha < checkBoxes.length; cecha++)
            {
                int atrybut = newPet.id_atrybuty[cecha]-1;
                if(!(atrybut < 0))
                    checkBoxes[cecha][atrybut].setChecked(true);
            }
        }*/

        final LayoutInflater factory = getLayoutInflater();

        final View textEntryView = factory.inflate(R.layout.define_create_new_advertisement, null);

        upOfLayout          = findViewById(R.id.AbTopLayout);
        downOfLayout        = findViewById(R.id.AbBottomLayout);



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

        ConstraintLayout topLayout      = textEntryView.findViewById(R.id.TopLayout );
        ConstraintLayout bottomLayout   = textEntryView.findViewById(R.id.BottomLayout );

        //placek                          = textEntryView.findViewById(R.id.PLACEHOLDER_obraz);

        imageView           = textEntryView.findViewById(R.id.imageView);

        ed_choroby          = textEntryView.findViewById(R.id.editChoroby );
        ed_opis             = textEntryView.findViewById(R.id.editOpis);
        ed_imie             = textEntryView.findViewById(R.id.editImie    );
        ed_wiek             = textEntryView.findViewById(R.id.editWiek    );
        ed_koszt            = textEntryView.findViewById(R.id.editKoszt);

        ed_wiek.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        ed_koszt.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "1000000")});

        buttonImage         = textEntryView.findViewById(R.id.buttonImage);
        buttonImage.setText("Dodaj zdjęcie");

        TextView textKoszt = textEntryView.findViewById(R.id.textKoszt);
        TextView textChoroby = textEntryView.findViewById(R.id.textChoroby);
        TextView textOpis = textEntryView.findViewById(R.id.textOpis);


        ((ViewGroup)topLayout.getParent()).removeAllViews();
        ((ViewGroup)textKoszt.getParent()).removeAllViews();

        context = getApplicationContext();

        buttonImage     .setOnClickListener(v ->  startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY));
        buttonGotowe    .setOnClickListener(this::clickGotowe);
        buttonWroc      .setOnClickListener(this::backToMenu);

        upOfLayout.addView(topLayout);

        /* z jakiegos powodu nie działa downOfLayout.addView(bottomLayout);
        * TODO: Znalezc powod czemu nie dziala i trzeba recznie wszystkie dodawac
        * */
        downOfLayout.addView(textKoszt);
        downOfLayout.addView(ed_koszt);
        downOfLayout.addView(textChoroby);
        downOfLayout.addView(ed_choroby);
        downOfLayout.addView(textOpis);
        downOfLayout.addView(ed_opis);


    }

    public void clickGotowe(View v)
    {
        if( newPet.stringUriImage != null){

            if(!ed_choroby.getText().toString().matches(""))    newPet.setChorobyOrazProblemy(ed_choroby.getText().toString());
            if(!ed_opis.getText().toString().matches(""))       newPet.setOpis(ed_opis.getText().toString());
            if(!ed_imie.getText().toString().matches(""))       newPet.setImie(ed_imie.getText().toString());
            if(!ed_wiek.getText().toString().matches(""))       newPet.setWiek(Integer.parseInt(ed_wiek.getText().toString()));
            if(!ed_koszt.getText().toString().matches(""))      newPet.setMiesiecznyKosztUtrzymania(Integer.parseInt(ed_koszt.getText().toString()));

            Intent intent = new Intent(this, SendDataAboutNewPet.class).putExtra("Pet", newPet);
            startActivityForResult(intent,REQUEST_EXIT);
            //startActivity(intent);

            //finish();
        }
        else
        {
            DialogFragment messagebox = new MyDialogFragment();
            messagebox.show(this.getFragmentManager(), "Aby kontynuować należy wprowadzić zdjęcie");
        }
    }


    /* Moj clickListener, zeby moc sprecyzowac konkretny zbior cech i atrybut */
    private class MyOnClickListener implements View.OnClickListener
    {

        int cecha;
        int atrybut;

        MyOnClickListener(int cecha, int atrybut)
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            try {
                Uri selectedImage = data.getData();
                newPet.stringUriImage = selectedImage.toString();

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                PhotoEditor.setImage(imageView, bitmap, selectedImage, getApplicationContext());

                buttonImage.setText("Zmien zdjęcie");

            } catch (FileNotFoundException e) {
                
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        else if(resultCode==REQUEST_EXIT){
            DialogFragment messagebox = new MyDialogFragment();
            messagebox.show(this.getFragmentManager(), "Aby kontynuować należy wprowadzić zdjęcie");

            finish();
        }
    }

    public void backToMenu(View v)
    {
        setContentView(R.layout.menu_layout);
        finish();

    }




}
