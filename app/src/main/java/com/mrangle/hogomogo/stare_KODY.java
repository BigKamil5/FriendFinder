package com.mrangle.hogomogo;

public class stare_KODY {

    /*
public class SearchActivity2 extends AppCompatActivity {

    private ConstraintLayout layout;
    private ConstraintSet   constraintSetOld = new ConstraintSet();
    private ConstraintSet   constraintSetNew = new ConstraintSet();
    private boolean altLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        layout = findViewById(R.id.layout);
        constraintSetOld.clone(layout);
        constraintSetNew.clone(this,R.layout.activity_search2_alt);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void swapViews(View v)
    {

        TransitionManager.beginDelayedTransition(layout);

        if(!altLayout)
        {
            constraintSetNew.applyTo(layout);
            altLayout = true;
        }
        else
        {
            constraintSetOld.applyTo(layout);
            altLayout = false;
        }
    }
}*/

    /*
    <LinearLayout
                android:id="@+id/layShowobraz"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:orientation="vertical"
                android:background="@color/colorPrimaryDark">


                <de.hdodenhof.circleimageview.CircleImageView xmlns:app="http://schemas.android.com/apk/res-auto"
                    android:id="@+id/imageView"
                    android:layout_width="200dp"
                    android:layout_height="200dp"

                    android:layout_gravity="center_horizontal"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toTopOf="parent" />
            </LinearLayout>


            <!-- wiek-->
            <TextView
                android:id="@+id/petWiek"
                android:layout_width="111dp"
                android:layout_height="20dp"
                android:layout_marginLeft="24dp"
                android:layout_marginStart="24dp"
                android:layout_marginTop="16dp"
                android:ems="10"
                android:hint="@string/notatka_Wiek"


                app:layout_constraintStart_toEndOf="@+id/petImie"
                app:layout_constraintTop_toBottomOf="@+id/layShowobraz"
                tools:ignore="LabelFor" />

            <!-- imie-->
            <TextView
                android:id="@+id/petImie"
                android:layout_width="wrap_content"
                android:layout_height="30dp"
                android:layout_marginLeft="16dp"
                android:layout_marginStart="16dp"
                android:layout_marginTop="16dp"
                android:ems="10"

                android:hint="@string/notatka_Imie"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/layShowobraz" />


            <!-- Gatunek -->
            <TextView
                android:id="@+id/textGatunek"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_Gatunek"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petImie" />


            <TextView
                android:id="@+id/petGatunek"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textGatunek" />


            <!-- Dlugosc Siersci -->
            <TextView
                android:id="@+id/textDlugoscSiersci"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_DlugoscSiersci"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petGatunek" />

            <TextView
                android:id="@+id/petDlugoscSiersci"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textDlugoscSiersci" />



            <!-- Aktywnosc -->
            <TextView
                android:id="@+id/textAktywnosc"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_ZapotrzebowanieNaAktywnosc"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petDlugoscSiersci" />

            <TextView
                android:id="@+id/petAktywnosc"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textAktywnosc" />


            <!-- Ruchliwosc -->
            <TextView
                android:id="@+id/textRuchliwosc"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_Ruchliwosc"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petAktywnosc" />

            <TextView
                android:id="@+id/petRuchliwosc"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textRuchliwosc" />


            <!-- Nastawienie do czlowieka -->
            <TextView
                android:id="@+id/textNastawienieDoCzlowieka"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_NastawienieDoCzlowieka"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petRuchliwosc" />

            <TextView
                android:id="@+id/petNastawienieDoCzlowieka"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textNastawienieDoCzlowieka" />




            <!-- Nastawienie do dzieci -->
            <TextView
                android:id="@+id/textNastawienieDoDzieci"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_NastawienieDoDzieci"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petNastawienieDoCzlowieka" />

            <TextView
                android:id="@+id/petNastawienieDoDzieci"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textNastawienieDoDzieci" />



            <!-- Nastawienie do innych zwierzat -->
            <TextView
                android:id="@+id/textNastawienieDoInnychZwierzat"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_NastawienieDoInnychXwierzat"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petNastawienieDoDzieci" />

            <TextView
                android:id="@+id/petNastawienieDoInnychZwierzat"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textNastawienieDoInnychZwierzat" />



            <!-- Skłonności do niszczenia -->
            <TextView
                android:id="@+id/textSlonnoscDoNiszczenia"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_SklonnosciDoDiszczenia"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petNastawienieDoInnychZwierzat" />

            <TextView
                android:id="@+id/petSlonnoscDoNiszczenia"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textSlonnoscDoNiszczenia" />



            <!-- Stopien Uczulania -->
            <TextView
                android:id="@+id/textStopienUczulania"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:text="@string/notatka_StopienUczulania"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petSlonnoscDoNiszczenia" />

            <TextView
                android:id="@+id/petStopienUczulania"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textStopienUczulania" />



            <!-- Miesięczny koszt utrzymania -->
            <TextView
                android:id="@+id/textKoszt"
                android:layout_width="230dp"
                android:layout_height="20dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:ems="10"
                android:text="@string/notatka_MiesiecznyKosztUtrzymania"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petStopienUczulania" />

            <TextView
                android:id="@+id/petKoszt"
                android:layout_width="220dp"
                android:layout_height="25dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textKoszt" />


            <!-- Przebyte lub aktualne choroby -->
            <TextView
                android:id="@+id/textChoroby"
                android:layout_width="225dp"
                android:layout_height="20dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:ems="10"
                android:text="@string/notatka_PrzebyteLubAktualneChoroby"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petKoszt" />

            <TextView
                android:id="@+id/petChoroby"
                android:layout_width="220dp"
                android:layout_height="wrap_content"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textChoroby" />


            <!-- Opis -->
            <TextView
                android:id="@+id/textOpis"
                android:layout_width="225dp"
                android:layout_height="20dp"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"
                android:ems="10"
                android:text="@string/notatka_Opis"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petChoroby" />

            <TextView
                android:id="@+id/petOpis"
                android:layout_width="220dp"
                android:layout_height="wrap_content"
                android:layout_marginLeft="32dp"
                android:layout_marginStart="32dp"
                android:layout_marginTop="16dp"

                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textOpis" />


            <Button
                android:id="@+id/buttonGotowe"
                android:layout_width="75dp"
                android:layout_height="75dp"
                android:layout_marginBottom="16dp"

                android:layout_marginEnd="85dp"
                android:layout_marginRight="85dp"
                android:layout_marginTop="16dp"


                android:background="@mipmap/check_image"
                android:onClick="clickGotowe"

                android:textStyle="bold"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petOpis" />

            <Button
                android:id="@+id/buttonWroc"
                android:layout_width="75dp"
                android:layout_height="75dp"
                android:layout_marginBottom="16dp"


                android:layout_marginEnd="62dp"

                android:layout_marginLeft="85dp"
                android:layout_marginRight="62dp"
                android:layout_marginStart="85dp"
                android:layout_marginTop="16dp"
                android:background="@mipmap/cancel_image"
                android:onClick="backToEditMenu"
                android:textStyle="bold"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toStartOf="@+id/buttonGotowe"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/petOpis"
                app:layout_constraintVertical_bias="0.0" />

     */

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
