package com.mrangle.hogomogo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View.OnClickListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.mrangle.hogomogo.Adapter.ShelterListAdapter;
import com.mrangle.hogomogo.Functionalities.ShelterListData;
import com.mrangle.hogomogo.R;

import java.util.ArrayList;
import java.util.List;

public class ShelterListActivity extends AppCompatActivity {
    ArrayList<ShelterListData> shelterListData;
    private RecyclerView mRecyclerView;
    private ShelterListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button shelterDetailsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        // Lookup the recyclerview in activity layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvShelter);
        shelterDetailsButton = findViewById(R.id.details_button);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        shelterListData = ShelterListData.createContactsList(20);
        // specify an adapter (see also next example)
        mAdapter = new ShelterListAdapter(shelterListData,getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);


    }

}
