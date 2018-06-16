package com.mrangle.hogomogo.Activity.Search;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrangle.hogomogo.Activity.CheckBoxActivity.SendDataAboutNewPet;
import com.mrangle.hogomogo.Class.Globals;
import com.mrangle.hogomogo.Class.Pet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SearchByUser extends NewSearchActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnAccept.setOnClickListener(this::clickGotowe);
    }



    public void clickGotowe(View v)
    {
        //TODO : Odbieranie z serwera
        setResult(REQUEST_EXIT, null);
        finish();
    }
}
