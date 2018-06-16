package com.mrangle.hogomogo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mrangle.hogomogo.Activity.CheckBoxActivity.DefineUserCriterion;
import com.mrangle.hogomogo.Activity.LoginAndRegister.RegisterActivity;
import com.mrangle.hogomogo.Activity.ShelterDetails;
import com.mrangle.hogomogo.Activity.ShelterListActivity;
import com.mrangle.hogomogo.Functionalities.ShelterListData;
import com.mrangle.hogomogo.R;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class ShelterListAdapter extends
    RecyclerView.Adapter<ShelterListAdapter.ViewHolder> {
        public int pos;
        private Context context;
        // Provide a direct reference to each of the views within a data item
        // Used to cache the views within the item layout for fast access
        public class ViewHolder extends RecyclerView.ViewHolder  {
            // Your holder should contain a member variable
            // for any view that will be set as you render a row
            public TextView nameTextView;
            public Button messageButton;


            public ViewHolder(View itemView) {

                super(itemView);

                nameTextView = (TextView) itemView.findViewById(R.id.shelter_name);
                messageButton = (Button) itemView.findViewById(R.id.details_button);
            }

        }
        // Store a member variable for the contacts
        private List<ShelterListData> mContacts;
        private final PublishSubject<ShelterListData> onClickSubject = PublishSubject.create();

        // Pass in the contact array into the constructor
    public ShelterListAdapter(List< ShelterListData> contacts, Context context) {
            mContacts = contacts;
            this.context = context;
        }

    public ShelterListData getItem(int position){
        return mContacts.get(position);
    }

        @Override
        public ShelterListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.activity_shelteritem, parent, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }

        // Involves populating data into the item through holder
        @Override
        public void onBindViewHolder(ShelterListAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
            ShelterListData contact = mContacts.get(position);

            pos = position;
            // Set item views based on your views and data model
            TextView textView = viewHolder.nameTextView;
            textView.setText(contact.getName());
            Button button = viewHolder.messageButton;
            button.setText("Shelter details");
            button.setEnabled(true);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    onClickSubject.onNext(contact);

                    System.out.println(contact.getName());
                    Intent intent = new Intent(v.getContext(), ShelterDetails.class);
                    intent.putExtra("Object",contact);

                    if(contact != null){
                    v.getContext().startActivity(intent);}
                }
            });
        }

        // Returns the total count of items in the list
        @Override
        public int getItemCount() {
            return mContacts.size();
        }



}
