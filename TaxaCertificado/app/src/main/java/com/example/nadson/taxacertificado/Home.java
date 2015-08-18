package com.example.nadson.taxacertificado;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.*;
import android.widget.*;
import android.view.MenuItem;
import android.content.*;

public class Home extends DebugActivity implements View.OnClickListener{

    private ImageButton btn_home;
    private RelativeLayout layout_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(this);

        layout_home = (RelativeLayout) findViewById(R.id.layout_home);
        layout_home.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
