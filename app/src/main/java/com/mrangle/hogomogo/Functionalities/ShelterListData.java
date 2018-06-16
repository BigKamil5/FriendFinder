package com.mrangle.hogomogo.Functionalities;

import java.io.Serializable;
import java.util.ArrayList;

public class ShelterListData implements Serializable {
    private String mName;

    public ShelterListData(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }



    private static int lastContactId = 0;

    public static ArrayList<ShelterListData> createContactsList(int numContacts) {
        ArrayList<ShelterListData> contacts = new ArrayList<ShelterListData>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new ShelterListData("Shelter " + ++lastContactId));
        }

        return contacts;
    }
}
