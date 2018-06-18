package com.mrangle.hogomogo.Activity;

import com.mrangle.hogomogo.R;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DisplayFavoriteAnimals extends AppCompatActivity {

    final float scale = getContext().getResources().getDisplayMetrics().density;
    ConstraintLayout layPet;
    ConstraintLayout listOfPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_favorite_animals);

        final LayoutInflater factory = getLayoutInflater();
        final View textEntryView = factory.inflate(R.layout.display_pet, null);

        /*ConstraintLayout layPet1 = textEntryView.findViewById(R.id.PetView);



        listOfPets = findViewById(R.id.listOfPets);

        listOfPets.addView(layPet1);
        final View textEntryView2 = factory.inflate(R.layout.display_pet, null);
        ConstraintLayout layPet2 = textEntryView2.findViewById(R.id.PetView);

        TextView tx = textEntryView2.findViewById(R.id.NameText);
        tx.setText("DSAJIO");

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layPet2);

        constraintSet.connect(listOfPets.getId(), ConstraintSet.BOTTOM,layPet2.getId(),ConstraintSet.TOP,0);
        constraintSet.applyTo(layPet2);
        listOfPets.addView(layPet2); */
    }

    private void Create()
    {

        int pixels = (int) (dps * scale + 0.5f);

        CircleImageView cr = new CircleImageView(this);
        cr.getLayoutParams().height = "100dp";
    }
}
