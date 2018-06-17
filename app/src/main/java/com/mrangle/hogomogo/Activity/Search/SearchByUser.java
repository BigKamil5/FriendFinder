package com.mrangle.hogomogo.Activity.Search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrangle.hogomogo.Activity.CheckBoxActivity.SendDataAboutNewPet;
import com.mrangle.hogomogo.Activity.LoginAndRegister.LoginActivity;
import com.mrangle.hogomogo.Class.Globals;
import com.mrangle.hogomogo.Class.Pet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SearchByUser extends NewSearchActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnAccept.setOnClickListener(this::clickGotowe);
        Login();
    }

    private void Login() {
        final String name = "Merlin";
        final String age = "1";

        //loading.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Globals.URL_GET_DATA_ABOUT_PET,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("res");

                        if (success.equals("1")) {

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject object = jsonArray.getJSONObject(i);

                                String name1 = object.getString("name").trim();
                                String age1 = object.getString("age").trim();
                                String id = object.getString("id").trim();


                                messagebox.show(this.getFragmentManager(), name1 + age1 + id);

                                //Toast.makeText(SearchByUser.this, "cos", Toast.LENGTH_LONG).show();

                                //loading.setVisibility(View.GONE);


                            }

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        //loading.setVisibility(View.GONE);
                        //Toast.makeText(SearchByUser.this, "Error " +e.toString(), Toast.LENGTH_SHORT).show();
                        messagebox.show(this.getFragmentManager(),"Error " +e.toString());
                    }
                },
                error -> {
                    //loading.setVisibility(View.GONE);
                    Toast.makeText(SearchByUser.this, "Error " +error.toString(), Toast.LENGTH_SHORT).show();

                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("age", age);
                params.put("name", name);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }



    public void clickGotowe(View v)
    {
        //TODO : Odbieranie z serwera
        setResult(REQUEST_EXIT, null);
        finish();
    }
}
