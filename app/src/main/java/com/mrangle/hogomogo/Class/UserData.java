package com.mrangle.hogomogo.Class;

public class UserData {

    public static final int MIN = 0;
    public static final int MAX = 1;

    public static int[] wiek = { 0, 0 };

    public static int[] koszt = { 0, 0 };

    /* odniesienie do konkretnych elementów zdefiniowane w klasie PET */
    public static boolean[][] kryterium = {
            {false, false, false, false},           //GATUNEK
            {false, false, false, false, false},    //DLUGOSCSIERSCI
            {false, false, false, false},           //ZAPOTRZEBOWANIE_NA_AKTYWNOSC
            {false, false, false, false},           //RUCHLIWOSC
            {false, false, false, false},           //NASTAWIENIE_DO_CZLOWIEKA
            {false, false, false, false},           //NASTAWIENIE_DO_DZIECI
            {false, false, false, false},           //NASTAWIENIE_DO_INNYCH_ZWIERZAT
            {false, false, false, false},           //SKLONNOSC_DO_NISZCZENIA
            {false, false, false, false, false},    //STOPIEN_UCZULANIA
    };



}
