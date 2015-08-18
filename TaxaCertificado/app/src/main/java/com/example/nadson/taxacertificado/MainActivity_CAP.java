package com.example.nadson.taxacertificado;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.text.NumberFormat;


public class MainActivity_CAP extends Activity implements View.OnClickListener{

    private EditText edit_atc;
    private Button btn_calcular;

    NumberFormat nf = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap);

        edit_atc = (EditText) findViewById(R.id.edit_atc);

        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(this);

        //cria��o do button voltar na action bar
        ActionBar actionBar = getActionBar();
       actionBar.setDisplayHomeAsUpEnabled(true);

    }


    public void onClick(View v){

        float ufr = 23.6f;
        double valoratc = Double.parseDouble(edit_atc.getText().toString());

        double valor = valoratc * 0.02 * ufr;

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("Taxa a ser paga " + nf.format(valor));
        dlg.setNeutralButton("OK", null);
        dlg.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

            //cria��o da condi��o de retorno para a home pelo button da action bar
            if (id == android.R.id.home){
                finish();
                return true;
            }

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

        return super.onOptionsItemSelected(item);
    }
}
