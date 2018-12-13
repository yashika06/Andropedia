package com.android.yashika.andropedia;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Yashika on 27-07-2017.
 */

public class QuePrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "androidwave-questions";
    public QuePrefManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setQuestion(int question,String ans) {
        editor.putString(String.valueOf(question),ans);
        editor.commit();
    }
    public String getAns(int question){
        return pref.getString(String.valueOf(question),null);
    }
    public void removeAll(){
        editor.clear();
        editor.commit();
    }
}
