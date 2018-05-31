package com.mrangle.hogomogo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mrangle.hogomogo.R;

public class MojActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moj);

    }

    public void NewActivity(View v)
    {
        setContentView(R.layout.activity_search);
        finish();

    }
}
