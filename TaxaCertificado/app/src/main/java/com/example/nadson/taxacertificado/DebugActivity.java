package com.example.nadson.taxacertificado;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Nadson on 24/07/2015.
 */
public class DebugActivity  extends Activity{
    protected static final String TAG = "taxa";

    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        Log.i(TAG,getLocalClassName()+".onCreate() chamado:"+ icicle);
    }

    protected void onStart(){
        super.onStart();
        Log.i(TAG, getLocalClassName()+".onStart()chamado.");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, getLocalClassName()+".onRestart()chamado.");
    }

    protected void onResume(){
        super.onResume();
        Log.i(TAG, getLocalClassName()+".onResume()chamdo.");
    }

    protected void onPause(){
        super.onPause();
        Log.i(TAG, getLocalClassName()+".onPause()chamado");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i(TAG, getLocalClassName()+".onSaveInstanceState()chamado.");
    }

    protected void onStop(){
        super.onStop();
        Log.i(TAG, getLocalClassName()+".onStop()chamado.");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, getLocalClassName()+".onDestroy()chamado.");
    }

    private String getClassName(){
        String s= getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}
