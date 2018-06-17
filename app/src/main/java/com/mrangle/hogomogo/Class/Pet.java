package com.mrangle.hogomogo.Class;

import java.io.Serializable;

public class Pet implements Serializable
{
    public static final int GATUNEK                         = 0;
    public static final int DLUGOSCSIERSCI                  = 1;
    public static final int ZAPOTRZEBOWANIE_NA_AKTYWNOSC    = 2;
    public static final int RUCHLIWOSC                      = 3;
    public static final int NASTAWIENIE_DO_CZLOWIEKA        = 4;
    public static final int NASTAWIENIE_DO_DZIECI           = 5;
    public static final int NASTAWIENIE_DO_INNYCH_ZWIERZAT  = 6;
    public static final int SKLONNOSC_DO_NISZCZENIA         = 7;
    public static final int STOPIEN_UCZULANIA               = 8;


    public final static int BRAK_INFORMACJI = 0;
    public final static int PIES = 1;
    public final static int KOT = 2;
    public final static int INNE = 3;


    public final static int DLUGIE = 1;
    public final static int SREDNIE = 2;
    public final static int KROTKIE = 3;
    public final static int BRAK = 4;

    public final static int WYSOKA = 1;
    public final static int SREDNIA = 2;
    public final static int NISKA = 3;

    public final static int PRZYJAZNE = 1;
    public final static int OBOJETNE = 2;
    public final static int AGRESYWNE = 3;


    //powiedzmy ze zwierze ma wartosc przy dlugosci siersci ustawione na 2
    //niech zwierze nazywa sie : newPet
    /*
    zamist sprawdzac czy user zgadza sie na dlugosc siersci średnie ( średnie czyli = 2)
    for(int i = 0; i < lenght; i++)
        if (kryterium[dlugoscSiersci][i] == true)
            wynik++;

    wystarczy zrobić po prostu
        if (kryterium[dlugoscSiersci][newPet.dlugoscSiersci] == true)
            wynik++;

        // bo newPet.gatunek = 2, a to 2 odpowiada prawdzie/falszowi (w zwiazku z srednia dlugoscia siersci) z kryterium uzytkownika.
     */

    /*

    Algorytm działania :
    zakladajac ze mamy dwuwymiarowa tablice kryterium...

    i zwierza (jako newPet) też mamy w tablicy jednowymiarowej
     id_atrybuty = {
            0, // Gatunek            // tutaj jakies wartosci
            0, // Dlugosc siersci
            0, // ZAPOTRZEBOWANIE_NA_AKTYWNOSC
            0, // RUCHLIWOSC
            0, // NASTAWIENIE_DO_CZLOWIEKA
            0, // NASTAWIENIE_DO_DZIECI
            0, // NASTAWIENIE_DO_INNYCH_ZWIERZAT
            0, // SKLONNOSC_DO_NISZCZENIA
            0, // STOPIEN_UCZULANIA
    };
    to najszybicej mozna sprawdzic poprawnosc:

    for(int i = 0; i < id_atrybuty.lenght; i++)
        // jesli i = 0, to dla zwierza i dla kryterium bedzie sprawdzany garunek i od razu
        // przejdzie do sprawdzania czy wartosc lezaca pod indeksem = newPet.id_atrybuty[i] == true
        // zamiast przechodzac po kolei przez wszystkie indeksy
        if( kryterium[i][newPet.id_atrybuty[i]] == true )
            wynik++;

    // nic wiecej dla jednego zwierza

    // jesli to będa 2 tablice ( w tym jedna jednowymiarowa(zwierza), druga dwuwymiarowa(uzytkownika),
    to powinno działać ( na takiej samej zasadzie dziala przy okreslaniu checkboxow itd... wiec mam pewnosc ze to jest ok)


     */



    // używane jako zbiorCech[cecha][atrybut] - zwraca String określajacy dana ceche //
    /*
    Przyklad: .zbiorCech[DLUGOSC_SIERSCI][SREDNIE] zwraca String "SREDNIE"
     */
    public static String[][] zbiorCech = {
            {"Brak informacji", "Pies", "Kot", "Inne"},                     // Gatunek
            {"Brak informacji", "Dlugie", "Srednie", "Krotkie", "Brak"},    // Dlugosc siersci
            {"Brak informacji", "Wysoka", "Srednia", "Niska"},              // ZAPOTRZEBOWANIE_NA_AKTYWNOSC
            {"Brak informacji", "Wysoka", "Srednia", "Niska"},              // RUCHLIWOSC
            {"Brak informacji", "Przyjazne", "Obojetne", "Agresywne"},      // NASTAWIENIE_DO_CZLOWIEKA
            {"Brak informacji", "Przyjazne", "Obojetne", "Agresywne"},      // NASTAWIENIE_DO_DZIECI
            {"Brak informacji", "Przyjazne", "Obojetne", "Agresywne"},      // NASTAWIENIE_DO_INNYCH_ZWIERZAT
            {"Brak informacji", "Wysoka", "Srednia", "Niska"},              // SKLONNOSC_DO_NISZCZENIA
            {"Brak informacji", "Wysoki", "Sredni", "Niski"},               // STOPIEN_UCZULANIA
    };

    //  identyfikuje konkretny atrybut:
    /*
        Przyklad:
        .id_atrybuty[GATUNEK] = PIES;
        przypisuje indentyfikator PIES jako Gatunek.
     */
    public int[] id_atrybuty = {
            0, // Gatunek
            0, // Dlugosc siersci
            0, // ZAPOTRZEBOWANIE_NA_AKTYWNOSC
            0, // RUCHLIWOSC
            0, // NASTAWIENIE_DO_CZLOWIEKA
            0, // NASTAWIENIE_DO_DZIECI
            0, // NASTAWIENIE_DO_INNYCH_ZWIERZAT
            0, // SKLONNOSC_DO_NISZCZENIA
            0, // STOPIEN_UCZULANIA
    };

    private int id;



    public String stringUriImage;


    /*
     * ponizsze atrybuty to ogolny opis stworzony przez wstawiajacego ogloszenie.
     */
    private String opis;
    private String chorobyOrazProblemy;
    private String imie;
    private int miesiecznyKosztUtrzymania;
    private int wiek;
    private int waga;

    public Pet()
    {
        id                          = -1;
        /*gatunek                     = Gatunek.BRAK_INFORMACJI;
        dlugoscSiersci              = DlugoscSiersci.BRAK_INFORMACJI;
        nastawienieDoCzlowieka      = NastawienieDoCzlowieka.BRAK_INFORMACJI;
        nastawienieDoDzieci         = NastawienieDoDzieci.BRAK_INFORMACJI;
        nastawienieDoInnychZwierzat = NastawienieDoInnychZwierzat.BRAK_INFORMACJI;
        stopienUczulania            = StopienUczulania.BRAK_INFORMACJI;
        zapotrzebowanieNaAktywnosc  = ZapotrzebowanieNaAktywnosc.BRAK_INFORMACJI;
        ruchliwosc                  = Ruchliwosc.BRAK_INFORMACJI;
        sklonnosciDoNiszczenia      = SklonnosciDoNiszczenia.BRAK_INFORMACJI;*/
        opis                        = "Brak";
        chorobyOrazProblemy         = "Brak";
        imie                        = "Brak informacjie";
        miesiecznyKosztUtrzymania   = -1;
        wiek                        = -1;
        waga                        = -1;
    }

    /* GETTERY I SETTERY */

    /*public Uri getPetImage() {
        //return petImage;
    }

    public void setPetImage(Uri petImage) {
        //this.petImage = petImage;
    }*/


    public String getImie()
    {
        return imie;
    }
    public void setImie(String imie)
    {
        this.imie = imie;
    }


    public int getWiek()
    {
        return wiek;
    }
    public void setWiek(int wiek)
    {
        this.wiek = wiek;
    }



    public int getWaga()
    {
        return waga;
    }
    public void setWaga(int waga)
    {
        this.waga = waga;
    }



    public int getMiesiecznyKosztUtrzymania()
    {
        return miesiecznyKosztUtrzymania;
    }
    public void setMiesiecznyKosztUtrzymania(int miesiecznyKosztUtrzymania)
    {
        this.miesiecznyKosztUtrzymania = miesiecznyKosztUtrzymania;
    }



    public String getOpis()
    {
        return opis;
    }
    public void setOpis(String opis)
    {
        this.opis = opis;
    }


    public String getChorobyOrazProblemy()
    {
        return chorobyOrazProblemy;
    }
    public void setChorobyOrazProblemy(String chorobyOrazProblemy)
    {
        this.chorobyOrazProblemy = chorobyOrazProblemy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
