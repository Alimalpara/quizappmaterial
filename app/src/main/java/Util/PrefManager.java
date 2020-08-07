package Util;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static  final String Cookie="cookie";
    public static  final String PREF_NAME="QuizMAterial";

    Context context;
    int PRIVATE_MODE=0;

    public PrefManager( Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }
    public String getCookie(){

        String cookie=sharedPreferences.getString(Cookie,"");

        return cookie;
    }
    public void setCookie(String cookie){


        editor.putString(Cookie,cookie);
        editor.commit();
    }

}
