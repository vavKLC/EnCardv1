package com.example.encardv1.util;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class SharedPreferencesInj {
    SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesInj(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean getBoolen(){
        boolean isShow = sharedPreferences.getBoolean("isShow" , false);
        return isShow;
    }

    public void setBoolean(boolean isShow){
        sharedPreferences.edit().putBoolean("isShow", isShow).apply();
    }
}
