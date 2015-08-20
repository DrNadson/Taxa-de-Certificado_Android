package com.example.nadson.taxacertificado;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.ActionBar;

import java.text.NumberFormat;

/**
 * Main do Novo Layout para o CA - Created by Nadson on 18/07/2015.
 */
public class MainActivity_CA extends DebugActivity {

    private RadioButton btn_classif_residencial;
    private RadioButton btn_classif_outra;
    private EditText edit_atc;

    double valoratc;
    float ufr = 23.6f;
    double valor = valoratc * 0.008 * ufr;

    NumberFormat nf = NumberFormat.getCurrencyInstance();


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca);

        btn_classif_residencial = (RadioButton) findViewById(R.id.radioButton3);
        btn_classif_outra = (RadioButton) findViewById(R.id.radioButton4);

        edit_atc = (EditText) findViewById(R.id.edit_atc);


        //declarando meu button para poder usar no calculo dos CA's


        //cria��o do button voltar na action bar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    public void onRadioButtonResidencial(View view) {

        valoratc = Double.parseDouble(edit_atc.getText().toString());

        if (valoratc <= 200) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Você é isento de pagamento \n conforme Lei 6.546 de 29/12/1995");
            dlg.setNeutralButton("OK", null);
            dlg.show();

        } else if (valoratc > 200 && valoratc <= 750) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Taxa a ser paga " + nf.format(ufr));
            dlg.setNeutralButton("OK", null);
            dlg.show();

        } else if (valoratc > 750) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Taxa a ser paga " + nf.format(valor));
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    public void onRadioButtonOutra(View view) {

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

        if (id == android.R.id.home) {
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
