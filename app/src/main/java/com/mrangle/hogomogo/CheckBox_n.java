package com.mrangle.hogomogo;

import android.content.Context;
import android.widget.CheckBox;

public class CheckBox_n extends android.support.v7.widget.AppCompatCheckBox{

    public CheckBox c;
    private int typ_kryterium = 0;

    public CheckBox_n(Context context) {
        super(context);
        typ_kryterium = 0;
    }

    public void setType(int x)
    {
        typ_kryterium = x;
    }


    public CheckBox getC()
    {
        return c;
    }

}
