package com.mrangle.hogomogo;

import android.app.DialogFragment;
import android.app.FragmentManager;

public class UserData {

    public static final int gatunek                       = 0;
    public final int dlugoscSiersci                = 1;
    public final int zapotrzebowanieNaAktywnosc    = 2;
    public final int ruchliwosc                    = 3;
    public final int nastawienieDoCzlowieka        = 4;
    public final int nastawienieDoDzieci           = 5;
    public final int nastawienieDoInnychZwierzat   = 6;
    public final int sklonnoscDoNiszczenia         = 7;
    public final int stopienUczulania              = 8;
    /*public enum Gatunek
    {
        Pies, Kot, Inne, BrakInformacji;
    }
    public enum DlugoscSiersci
    {
        Dlugie, Srednie, Krotkie, Brak, BrakInformacji;
    }
    public enum ZapotrzebowanieNaAktywnosc
    {
        Wysoka, Srednia, Niska, BrakInformacji;
    }
    public enum Ruchliwosc
    {
        Wysoka, Srednia, Niska, BrakInformacji;
    }
    public enum NastawienieDoCzlowieka
    {
        Przyjazne, Obojetne, Agresywne, BrakInformacji;
    }
    public enum NastawienieDoDzieci
    {
        Przyjazne, Obojetne, Agresywne, BrakInformacji;
    }
    public enum NastawienieDoInnychZwierzat
    {
        Przyjazne, Obojetne, Agresywne, BrakInformacji;
    }
    public enum SklonnosciDoNiszczenia
    {
        Wysoka, Srednia, Niska, BrakInformacji;
    }
    public enum StopienUczulania
    {
        Wysoki, Sredni, Niski, Brak, BrakInformacji;
    }*/

    public boolean[][] kryterium = {
        {false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false, false},
    };



}
