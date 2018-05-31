package com.mrangle.hogomogo.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mrangle.hogomogo.InputFilterMinMax;
import com.mrangle.hogomogo.R;

public class DefineUserCriterion extends AbLayout {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LayoutInflater factory = getLayoutInflater();

        final View textEntryView = factory.inflate(R.layout.activity_define_user_criterion, null);

        ConstraintLayout headLayout = textEntryView.findViewById(R.id.HeadLayout);

        upOfLayout          = findViewById(R.id.AbTopLayout);
        downOfLayout        = findViewById(R.id.AbBottomLayout);

        //ConstraintLayout con = textEntryView.findViewById(R.i);

        TextView textWiek       = textEntryView.findViewById(R.id.TextWiek);
        EditText ed_odWiek      = textEntryView.findViewById(R.id.editOdWiek);
        EditText ed_DoWiek      = textEntryView.findViewById(R.id.editDoWiek);

        ed_odWiek.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        ed_DoWiek.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});

        //button                  = textEntryView.findViewById(R.id.buttonGotowe);

        /* Kasowanie przydzielenie do konkretnego layoutu */
        ((ViewGroup)headLayout.getParent()).removeAllViews();



       // upOfLayout.addView(textWiek);
        //upOfLayout.addView(ed_odWiek);
        downOfLayout.addView(headLayout);

        /*downOfLayout.addView(textKoszt);
        downOfLayout.addView(ed_koszt);
        downOfLayout.addView(textChoroby);
        downOfLayout.addView(ed_choroby);
        downOfLayout.addView(textOpis);
        downOfLayout.addView(ed_opis);*/
        //downOfLayout.addView(button);

    }


}
