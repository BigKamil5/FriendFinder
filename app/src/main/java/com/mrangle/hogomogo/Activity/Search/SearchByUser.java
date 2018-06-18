package com.mrangle.hogomogo.Activity.Search;

import android.os.Bundle;
import android.view.View;

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
