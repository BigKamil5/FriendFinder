package com.mrangle.hogomogo;

import com.mrangle.hogomogo.Pet;

public class Advertisement {
    private Pet pet;
    private int id;

    public void addPet( Pet pet)
    {
        this.pet = pet;
    }

    public Pet getPet()
    {
        return pet;
    }
}
