package com.mrangle.hogomogo.Class;

import android.app.Application;

/**
 * Created by Megan on 2018-06-09.
 */


// Drogi Programosto pamiętaj!
    //JEBAC ZMIENNE GLOBALNE
//W ramach walki z nimi uzyjemy ich zeby pokazac jakie sa zle
    //Odkomentuj po prostu sowje pole ip a zakomentuj inne zeby projekt dzialal na Twoim lokalu

public class Globals extends Application {

    //Kamil
    //public static String yourIpAdress ="192.168.0.32";

    //Pietrek
    public static String yourIpAdress ="192.168.1.141";

    public static String URL_LOGIN = "http://"+yourIpAdress+"/myProjects/android_register_login/login.php";
    public static String URL_REGIST = "http://"+yourIpAdress+"/myProjects/android_register_login/register.php";
    public static String URL_READ = "http://"+yourIpAdress+"/myProjects/android_register_login/read_detail.php";
    public static String URL_EDIT = "http://"+yourIpAdress+"/myProjects/android_register_login/edit_detail.php";
    public static String URL_UPLOAD = "http://"+yourIpAdress+"/myProjects/android_register_login/upload.php";
    public static String URL_ADD_PET = "http://"+yourIpAdress+"/myProjects/android_register_login/add_pet.php";



    //Pietrek
    // private String yourIpAdress = ;

    public String getYourIp() {
        return yourIpAdress;
    }

    //public void setSomeVariable(String someVariable) {
    //   this.yourIpAdress = someVariable;
    //}
}


//http://192.168.0.32/myProjects/android_register_login/read_detail.php";