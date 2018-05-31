package com.mrangle.hogomogo.Activity;

import android.animation.Animator;
import android.app.DialogFragment;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mrangle.hogomogo.MyDialogFragment;
import com.mrangle.hogomogo.R;
import com.mrangle.hogomogo.UserData;


public class activity_menu extends AppCompatActivity {

    private View viewSearch;
    private View viewProfile;
    private View viewListOfAnimalShelter;
    private View viewObservedAnimals;



    private DialogFragment messagebox = new MyDialogFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        UserData user = new UserData();

        //messagebox.show(this.getFragmentManager(), String.valueOf(user.kryterium[UserData.gatunek][1]));
        //messagebox.show(this.getFragmentManager(), );
        viewSearch = findViewById(R.id.menuSearch);
        viewProfile = findViewById(R.id.menuProfile);
        viewListOfAnimalShelter = findViewById(R.id.menuListOfAnimalShelter);
        viewObservedAnimals = findViewById(R.id.menuObservedAnimals);

        YoYo.with(Techniques.Landing).duration(2000).playOn(viewSearch);
        YoYo.with(Techniques.Landing).duration(2000).playOn(viewProfile);
        YoYo.with(Techniques.Landing).duration(2000).playOn(viewListOfAnimalShelter);
        YoYo.with(Techniques.Landing).duration(2000).playOn(viewObservedAnimals);

    }

    private void StartWithAnimation(final View v, final Intent intent)
    {
        YoYo.with(Techniques.RotateIn).duration(700).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }
            @Override
            public void onAnimationEnd(Animator animation) {
                // tutaj startuje okienko
                startActivity(intent);
            }
            @Override
            public void onAnimationCancel(Animator animation) { }
            @Override
            public void onAnimationRepeat(Animator animation) { }
        }).playOn(v);

    }

    public void startSearch(View v)
    {
        Intent intent = new Intent(this, SearchActivity.class);
        StartWithAnimation(v, intent);
    }


    public void startProfile(View v)
    {
        //messagebox.show(this.getFragmentManager(), "jej!");
        Intent intent = new Intent(this, DefineUserCriterion.class);
        StartWithAnimation(v, intent);

        //Intent intent = new Intent(this, SearchActivity.class);
        //startActivity(intent);



    }
    public void startListOfAnimalShelter(View v)
    {
        //messagebox.show(this.getFragmentManager(), "jej!");
        Intent intent = new Intent(this, CreateNewAdvertisement.class);
        StartWithAnimation(v, intent);
        //Intent intent = new Intent(this, SearchActivity.class);
        //startActivity(intent);



    }
    public void startObservedAnimals(View v)
    {
        //messagebox.show(this.getFragmentManager(), "jej!");
        Intent intent = new Intent(this, SearchActivity.class);
        StartWithAnimation(v, intent);

        //Intent intent = new Intent(this, SearchActivity.class);
        //startActivity(intent);



    }
}
