

package com.mrangle.hogomogo.Activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mrangle.hogomogo.Activity.LoginAndRegister.SessionManager;
import com.mrangle.hogomogo.R;

public class MainActivity extends AppCompatActivity {
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        //sessionManager = new SessionManager(this);
        //sessionManager.checkLogin(); // to juz uruchamia nowe Activity


        Intent intent = new Intent(this, com.mrangle.hogomogo.Activity.LoginAndRegister.LoginActivity.class);
        startActivity(intent);
        finish();
    }

    protected void onResume() {
        super.onResume();


        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

    }


    }
