package com.mrangle.hogomogo.Activity.CheckBoxActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrangle.hogomogo.Activity.Search.NewSearchActivity;
import com.mrangle.hogomogo.Class.Globals;
import com.mrangle.hogomogo.Class.Pet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SendDataAboutNewPet extends NewSearchActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnAccept.setOnClickListener(this::clickGotowe);
    }

    public void SendToServer()
    {
        //TODO wysyłanie do serwera i tworzenie selekcikow
        loading.setVisibility(View.VISIBLE);
        btnAccept.setVisibility(View.GONE);



        final String ID                 = Integer.toString(this.pet.getId()).trim();
        final String Name               = this.pet.getImie().trim();
        final String Age                = Integer.toString(this.pet.getWiek());

        final String Type               = Integer.toString(this.pet.id_atrybuty[Pet.GATUNEK]).trim();
        final String LengthOfHair       = Integer.toString(this.pet.id_atrybuty[Pet.DLUGOSCSIERSCI]).trim();
        final String TheNeedForActivity = Integer.toString(this.pet.id_atrybuty[Pet.ZAPOTRZEBOWANIE_NA_AKTYWNOSC]).trim();
        final String Ruchliwosc         = Integer.toString(this.pet.id_atrybuty[Pet.RUCHLIWOSC]).trim();

        final String UriImage = this.pet.stringUriImage;

        Toast.makeText(SendDataAboutNewPet.this, (ID + Type + LengthOfHair + TheNeedForActivity), Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Globals.URL_ADD_PET,
                response -> {
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");

                        if (success.equals("1")) {
                            Toast.makeText(SendDataAboutNewPet.this, "Pet has beed added - Success!", Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                            btnAccept.setVisibility(View.VISIBLE);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(SendDataAboutNewPet.this, "Error! " + e.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btnAccept.setVisibility(View.VISIBLE);
                    }
                },
                error -> {
                    Toast.makeText(SendDataAboutNewPet.this, "Error! " + error.toString(), Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    btnAccept.setVisibility(View.VISIBLE);
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("ID", ID);
                params.put("Name", Name);
                params.put("Age", Age);
                params.put("Type", Type);
                params.put("LengthOfHair", LengthOfHair);
                params.put("TheNeedForActivity",TheNeedForActivity);
                params.put("Ruchliwosc", Ruchliwosc);
                params.put("UriImage", UriImage);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void clickGotowe(View v)
    {
        SendToServer();                         // wysylanie do bazy danych
        setResult(REQUEST_EXIT, null);
        finish();
    }
}
