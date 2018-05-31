package com.mrangle.hogomogo;

public class stare_KODY {

        /*
    public void checkSetAkSrednia(View v)
    {
        if(!checkAkSrednia.isChecked())
            newPet.zapotrzebowanieNaAktywnosc = Pet.ZapotrzebowanieNaAktywnosc.BrakInformacji;
        else
            newPet.zapotrzebowanieNaAktywnosc = Pet.ZapotrzebowanieNaAktywnosc.Srednia;
        checkAkWysoka.setChecked(false);
        checkAkNiska.setChecked(false);
    }
    public void checkSetAkNiska(View v)
    {
        if(!checkAkNiska.isChecked())
            newPet.zapotrzebowanieNaAktywnosc = Pet.ZapotrzebowanieNaAktywnosc.BrakInformacji;
        else
            newPet.zapotrzebowanieNaAktywnosc = Pet.ZapotrzebowanieNaAktywnosc.Niska;
        checkAkSrednia.setChecked(false);
        checkAkWysoka.setChecked(false);
    }

    //Ruchliwosc
    public void checkSetRuWysoka(View v)
    {
        if(!checkRuWysoka.isChecked())
            newPet.ruchliwosc = Pet.Ruchliwosc.BrakInformacji;
        else
            newPet.ruchliwosc = Pet.Ruchliwosc.Wysoka;
        checkRuSrednia.setChecked(false);
        checkRuNiska.setChecked(false);
    }
    public void checkSetRuSrednia(View v)
    {
        if(!checkRuSrednia.isChecked())
            newPet.ruchliwosc = Pet.Ruchliwosc.BrakInformacji;
        else
            newPet.ruchliwosc = Pet.Ruchliwosc.Srednia;
        checkRuWysoka.setChecked(false);
        checkRuNiska.setChecked(false);
    }
    public void checkSetRuNiska(View v)
    {
        if(!checkRuNiska.isChecked())
            newPet.ruchliwosc = Pet.Ruchliwosc.BrakInformacji;
        else
            newPet.ruchliwosc = Pet.Ruchliwosc.Niska;
        checkRuSrednia.setChecked(false);
        checkRuWysoka.setChecked(false);
    }

    //Nastawienie do czlowieka
    public void checkSetCzPrzyjazne(View v)
    {
        if(!checkCzPrzyjazne.isChecked())
            newPet.nastawienieDoCzlowieka = Pet.NastawienieDoCzlowieka.BrakInformacji;
        else
            newPet.nastawienieDoCzlowieka = Pet.NastawienieDoCzlowieka.Przyjazne;
        checkCzObojetne.setChecked(false);
        checkCzAgresywne.setChecked(false);
    }
    public void checkSetCzObojetne(View v)
    {
        if(!checkCzObojetne.isChecked())
            newPet.nastawienieDoCzlowieka = Pet.NastawienieDoCzlowieka.BrakInformacji;
        else
            newPet.nastawienieDoCzlowieka = Pet.NastawienieDoCzlowieka.Obojetne;
        checkCzPrzyjazne.setChecked(false);
        checkCzAgresywne.setChecked(false);
    }
    public void checkSetCzAgresywne(View v)
    {
        if(!checkCzAgresywne.isChecked())
            newPet.nastawienieDoCzlowieka = Pet.NastawienieDoCzlowieka.BrakInformacji;
        else
            newPet.nastawienieDoCzlowieka = Pet.NastawienieDoCzlowieka.Agresywne;
        checkCzObojetne.setChecked(false);
        checkCzPrzyjazne.setChecked(false);
    }

    //Nastawienie do dzieci
    public void checkSetDzPrzyjazne(View v)
    {
        if(!checkDzPrzyjazne.isChecked())
            newPet.nastawienieDoDzieci = Pet.NastawienieDoDzieci.BrakInformacji;
        else
            newPet.nastawienieDoDzieci = Pet.NastawienieDoDzieci.Przyjazne;
        checkDzObojetne.setChecked(false);
        checkDzAgresywne.setChecked(false);
    }
    public void checkSetDzObojetne(View v)
    {
        if(!checkDzObojetne.isChecked())
            newPet.nastawienieDoDzieci = Pet.NastawienieDoDzieci.BrakInformacji;
        else
            newPet.nastawienieDoDzieci = Pet.NastawienieDoDzieci.Obojetne;
        checkDzPrzyjazne.setChecked(false);
        checkDzAgresywne.setChecked(false);
    }
    public void checkSetDzAgresywne(View v)
    {
        if(!checkDzAgresywne.isChecked())
            newPet.nastawienieDoDzieci = Pet.NastawienieDoDzieci.BrakInformacji;
        else
            newPet.nastawienieDoDzieci = Pet.NastawienieDoDzieci.Agresywne;
        checkDzObojetne.setChecked(false);
        checkDzPrzyjazne.setChecked(false);
    }

    //Nastawienie do innych zwierzat
    public void checkSetZwPrzyjazne(View v)
    {
        if(!checkZwPrzyjazne.isChecked())
            newPet.nastawienieDoInnychZwierzat = Pet.NastawienieDoInnychZwierzat.BrakInformacji;
        else
            newPet.nastawienieDoInnychZwierzat = Pet.NastawienieDoInnychZwierzat.Przyjazne;
        checkZwObojetne.setChecked(false);
        checkZwAgresywne.setChecked(false);
    }
    public void checkSetZwObojetne(View v)
    {
        if(!checkZwObojetne.isChecked())
            newPet.nastawienieDoInnychZwierzat = Pet.NastawienieDoInnychZwierzat.BrakInformacji;
        else
            newPet.nastawienieDoInnychZwierzat = Pet.NastawienieDoInnychZwierzat.Obojetne;
        checkZwPrzyjazne.setChecked(false);
        checkZwAgresywne.setChecked(false);
    }
    public void checkSetZwAgresywne(View v)
    {
        if(!checkZwAgresywne.isChecked())
            newPet.nastawienieDoInnychZwierzat = Pet.NastawienieDoInnychZwierzat.BrakInformacji;
        else
            newPet.nastawienieDoInnychZwierzat = Pet.NastawienieDoInnychZwierzat.Agresywne;
        checkZwObojetne.setChecked(false);
        checkZwPrzyjazne.setChecked(false);
    }

    //Slonnosc do niszczenia
    public void checkSetNiWysoka(View v)
    {
        if(!checkNiWysoka.isChecked())
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.BrakInformacji;
        else
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.Wysoka;
        checkNiSrednia.setChecked(false);
        checkNiNiska.setChecked(false);
    }

    public void checkSetNiSrednia(View v)
    {
        if(!checkNiSrednia.isChecked())
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.BrakInformacji;
        else
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.Srednia;
        checkNiWysoka.setChecked(false);
        checkNiNiska.setChecked(false);
    }

    public void checkSetNiNiska(View v)
    {
        if(!checkNiNiska.isChecked())
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.BrakInformacji;
        else
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.Niska;
        checkNiSrednia.setChecked(false);
        checkNiWysoka.setChecked(false);
    }

    //stopien uczulania
    public void checkSetUczWysoki(View v)
    {
        if(!checkUczWysoki.isChecked())
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.BrakInformacji;
        else
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.Wysoka;
        checkUczSredni.setChecked(false);
        checkUczNiski.setChecked(false);
    }

    public void checkSetUczSredni(View v)
    {
        if(!checkUczSredni.isChecked())
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.BrakInformacji;
        else
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.Srednia;
        checkUczWysoki.setChecked(false);
        checkUczNiski.setChecked(false);
    }

    public void checkSetUczNiski(View v)
    {
        if(!checkUczNiski.isChecked())
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.BrakInformacji;
        else
            newPet.sklonnosciDoNiszczenia = Pet.SklonnosciDoNiszczenia.Niska;
        checkUczSredni.setChecked(false);
        checkUczWysoki.setChecked(false);
    }
*/


    /*public static Pet.Gatunek getGatunek(int index)
    {
        switch(index)
        {
            case (PIES):
                return Pet.Gatunek.Pies;
            case (KOT):
                return Pet.Gatunek.Kot;
            case(INNE):
                return Pet.Gatunek.Inne;

            default:
                return Pet.Gatunek.BRAK_INFORMACJI;
        }
    }*/

    public enum Gatunek {
        Pies, Kot, Inne, BRAK_INFORMACJI;
    }

    public enum DlugoscSiersci {
        Dlugie, Srednie, Krotkie, Brak, BRAK_INFORMACJI;
    }

    public enum ZapotrzebowanieNaAktywnosc {
        Wysoka, Srednia, Niska, BRAK_INFORMACJI;
    }

    public enum Ruchliwosc {
        Wysoka, Srednia, Niska, BRAK_INFORMACJI;
    }

    public enum NastawienieDoCzlowieka {
        Przyjazne, Obojetne, Agresywne, BRAK_INFORMACJI;
    }

    public enum NastawienieDoDzieci {
        Przyjazne, Obojetne, Agresywne, BRAK_INFORMACJI;
    }

    public enum NastawienieDoInnychZwierzat {
        Przyjazne, Obojetne, Agresywne, BRAK_INFORMACJI;
    }

    public enum SklonnosciDoNiszczenia {
        Wysoka, Srednia, Niska, BRAK_INFORMACJI;
    }

    public enum StopienUczulania {
        Wysoki, Sredni, Niski, Brak, BRAK_INFORMACJI;
    }
    public int id;
    public Gatunek gatunek;
    public DlugoscSiersci dlugoscSiersci;
    public NastawienieDoCzlowieka nastawienieDoCzlowieka;
    public NastawienieDoDzieci nastawienieDoDzieci;
    public NastawienieDoInnychZwierzat nastawienieDoInnychZwierzat;
    public StopienUczulania stopienUczulania;
    public ZapotrzebowanieNaAktywnosc zapotrzebowanieNaAktywnosc;
    public Ruchliwosc ruchliwosc;
    public SklonnosciDoNiszczenia sklonnosciDoNiszczenia;
    //public int wielkosc;
}
