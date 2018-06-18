package com.mrangle.hogomogo.Activity;

import android.Manifest;
import android.animation.Animator;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mrangle.hogomogo.Activity.CheckBoxActivity.CreateNewAdvertisement;
import com.mrangle.hogomogo.Activity.CheckBoxActivity.DefineUserCriterion;
import com.mrangle.hogomogo.Activity.CheckBoxActivity.SendDataAboutNewPet;
import com.mrangle.hogomogo.Activity.LoginAndRegister.LoginActivity;
import com.mrangle.hogomogo.Activity.LoginAndRegister.RegisterActivity;
import com.mrangle.hogomogo.Activity.LoginAndRegister.SessionManager;
import com.mrangle.hogomogo.Activity.Search.NewSearchActivity;
import com.mrangle.hogomogo.Activity.Search.SearchByUser;
import com.mrangle.hogomogo.Activity.StareDoNaukiAlboSprawdzania.SearchActivity;
import com.mrangle.hogomogo.Class.ExtensionClass.MyDialogFragment;
import com.mrangle.hogomogo.Class.Globals;
import com.mrangle.hogomogo.Class.Pet;
import com.mrangle.hogomogo.R;
import com.mrangle.hogomogo.Class.UserData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MenuActivity extends AppCompatActivity {

    private View viewSearch;
    private View viewProfile;
    private View viewListOfAnimalShelter;
    private View viewObservedAnimals;
    private Button logoutButton;
    private SessionManager sessionManager;

    private static int RESULT_LOAD_IMG = 1;
    public final int REQUEST_CODE_FOR_PERMISSIONS = 654;



    private static final int REQUEST_EXIT = 2;

    private Pet newPet;



    private DialogFragment messagebox = new MyDialogFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        UserData user = new UserData();

        //messagebox.show(this.getFragmentManager(), String.valueOf(user.kryterium[UserData.gatunek][1]));
       // messagebox.show(this.getFragmentManager(), UserData.getCriterionInString(Pet.GATUNEK));
        viewSearch = findViewById(R.id.menuSearch);
        viewProfile = findViewById(R.id.menuProfile);
        viewListOfAnimalShelter = findViewById(R.id.menuListOfAnimalShelter);
        viewObservedAnimals = findViewById(R.id.menuObservedAnimals);
        logoutButton = findViewById(R.id.logOutBt);



        sessionManager = new SessionManager(this);

        YoYo.with(Techniques.Landing).duration(2000).playOn(viewSearch);
        YoYo.with(Techniques.Landing).duration(2000).playOn(viewProfile);
        YoYo.with(Techniques.Landing).duration(2000).playOn(viewListOfAnimalShelter);
        YoYo.with(Techniques.Landing).duration(2000).playOn(viewObservedAnimals);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
                finish();
            }
        });




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_FOR_PERMISSIONS);
            }
        }

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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void startSearch(View v)
    {

        SearchPet();


        //StartWithAnimation(v, intent);
    }


    public void startProfile(View v)
    {
        //messagebox.show(this.getFragmentManager(), "jej!");
        Intent intent = new Intent(this, DefineUserCriterion.class);
        StartWithAnimation(v, intent);
        messagebox.show(this.getFragmentManager(), convertToStringArray(UserData.kryterium));
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
        Intent intent = new Intent(this, NewSearchActivity.class);
        StartWithAnimation(v, intent);

        //Intent intent = new Intent(this, SearchActivity.class);
        //startActivity(intent);



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE_FOR_PERMISSIONS){
            //You need to handle permission results, if user didn't allow them.
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void SearchPet() {
        final String name = "Merlin";
        final String age = "1";

        newPet = new Pet();


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

                                newPet.setImie(  object.getString("name").trim());
                                newPet.setWiek( Integer.parseInt(object.getString("age").trim()) );
                                newPet.setId( Integer.parseInt(object.getString("id").trim()));
                                newPet.id_atrybuty[Pet.GATUNEK] =  Integer.parseInt(object.getString("type").trim());
                                newPet.id_atrybuty[Pet.DLUGOSCSIERSCI] =  Integer.parseInt(object.getString("lengthOfHair").trim());
                                newPet.id_atrybuty[Pet.ZAPOTRZEBOWANIE_NA_AKTYWNOSC] =  Integer.parseInt(object.getString("theNeedForActivity").trim());
                                newPet.id_atrybuty[Pet.RUCHLIWOSC] =  Integer.parseInt(object.getString("ruchliwosc").trim());

                                newPet.stringUriImage =  object.getString("photo").trim();

                                Toast.makeText(this, newPet.getImie(), Toast.LENGTH_LONG).show();

                                //loading.setVisibility(View.GONE);
                                Intent intent = new Intent(this, SearchByUser.class).putExtra("Pet", newPet);
                                intent.addCategory(Intent.CATEGORY_OPENABLE);
                                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                intent.setType("photo/*");
                                startActivityForResult(intent,REQUEST_EXIT);

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
                    Toast.makeText(this, "Error " +error.toString(), Toast.LENGTH_SHORT).show();

                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("age", age);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

       // messagebox.show(this.getFragmentManager(), newPet.getImie());

    }

    private String convertToStringArray( boolean[][] arr)
    {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                if( arr[i][j] )
                    str.append("1");
                else
                    str.append("0");
            }
            str.append(",");
        }
        return str.toString();
    }


}
