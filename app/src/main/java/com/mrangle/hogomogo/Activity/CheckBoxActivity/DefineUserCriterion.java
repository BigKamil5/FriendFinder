package com.mrangle.hogomogo.Activity.CheckBoxActivity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrangle.hogomogo.Class.ExtensionClass.InputFilterMinMax;
import com.mrangle.hogomogo.Class.Globals;
import com.mrangle.hogomogo.Class.Pet;
import com.mrangle.hogomogo.R;
import com.mrangle.hogomogo.Class.UserData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DefineUserCriterion extends AbLayout {

    private static final int CHECKBOX_DIFFERENCE = 1;

    EditText ed_OdWiek ;
    EditText ed_DoWiek ;
    EditText ed_OdKoszt;
    EditText ed_DoKoszt;
    
    protected ProgressBar loading;
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
        
        loading             = textEntryView.findViewById(R.id.loading);

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
        SendToServer();

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

    public void SendToServer()
    {
        //TODO wysyłanie do serwera i tworzenie selekcikow
        loading.setVisibility(View.VISIBLE);
        buttonGotowe.setVisibility(View.GONE);



        final String ID = UserData.getCriterionInString(Pet.GATUNEK).trim();
        final String Type = UserData.getCriterionInString(Pet.GATUNEK).trim();
        final String LengthOfHair = UserData.getCriterionInString(Pet.DLUGOSCSIERSCI).trim();
        final String TheNeedForActivity = UserData.getCriterionInString(Pet.ZAPOTRZEBOWANIE_NA_AKTYWNOSC).trim();
        final String Ruchliwosc = UserData.getCriterionInString(Pet.RUCHLIWOSC).trim();

        Toast.makeText(DefineUserCriterion.this, (ID + Type + LengthOfHair + TheNeedForActivity), Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Globals.URL_SEND_USER_CRITERION,
                response -> {
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");

                        if (success.equals("1")) {
                            Toast.makeText(DefineUserCriterion.this, "Pet has beed added - Success!", Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                            buttonGotowe.setVisibility(View.VISIBLE);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(DefineUserCriterion.this, "Error! " + e.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        buttonGotowe.setVisibility(View.VISIBLE);
                    }
                },
                error -> {
                    Toast.makeText(DefineUserCriterion.this, "Error! " + error.toString(), Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    buttonGotowe.setVisibility(View.VISIBLE);
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("ID", ID);
                params.put("Type", Type);
                params.put("LengthOfHair", LengthOfHair);
                params.put("TheNeedForActivity",TheNeedForActivity);
                params.put("Ruchliwosc", Ruchliwosc);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}
