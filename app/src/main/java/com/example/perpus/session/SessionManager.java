package com.example.perpus.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.perpus.entity.User;
import com.google.gson.Gson;

public class SessionManager {

    private static SharedPreferences pref;

    private static SharedPreferences prefKeep;

    private SharedPreferences.Editor editor;

    private SharedPreferences.Editor editorKeep;

    private static final int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "perpustakaan";

    private static final String PREF_KEEP_NAME = "perpustakaan-keep";

    private static final String KEY_USER = "KEY_USER";

    private static final String IS_LOGIN = "IS_LOGIN";

    private static SessionManager instance = null;

    private Context context;


    public SessionManager(Context context) {
        this.context = context;

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        prefKeep = context.getSharedPreferences(PREF_KEEP_NAME, PRIVATE_MODE);

        editor = pref.edit();
        editor.apply();

        editorKeep = prefKeep.edit();
        editorKeep.apply();
    }

    public synchronized static SessionManager getInstance(Context context){
        if (instance == null){
            instance = new SessionManager(context.getApplicationContext());
        }

        return instance;
    }

    public boolean isLogin(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void doLogin(){
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    public void setCurrentLogin(User param){
        String user = new Gson().toJson(param);

        editor.putString(KEY_USER, user);
        editor.commit();
    }

    public User getCurrentLogin(){
        String user = pref.getString(KEY_USER, null);

        return new Gson().fromJson(user, User.class);
    }

    public void doLogout(){
        pref.getBoolean(IS_LOGIN, false);

        editor.clear();
        editor.apply();


    }



}
