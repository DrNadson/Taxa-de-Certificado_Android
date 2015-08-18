package com.example.nadson.taxacertificado;

//importa��es

import android.app.Activity;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.widget.SearchView;

public class MainActivity extends DebugActivity implements View.OnClickListener {

    //declara��o das views do meu layout activity_main

    private RadioButton btn_CA;
    private RadioButton btn_CAP;
    private Button btn_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //utiliza��o do m�todo que chama as minhas views

        btn_CA = (RadioButton) findViewById(R.id.radioButton);
        btn_CAP = (RadioButton) findViewById(R.id.radioButton2);

        //declara��o dos meus radiobutton para que eles ao serem clicados chamem o m�todo definido logo abaixo
        btn_CA.setOnClickListener(this);
        btn_CAP.setOnClickListener(this);

    }

    //mwtodo que cria�minha intent (mudando de page do app)
    public void onClick (View view){

        if(view.getId()==R.id.radioButton){

            Intent it = new Intent(this,MainActivity_CA.class);
            startActivity(it);}

                 else if (view.getId()==R.id.radioButton2) {

                    Intent it = new Intent(this,MainActivity_CAP.class);
                    startActivity(it);}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_pesquisar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(onSearch());
        return true;
    }

    private SearchView.OnQueryTextListener onSearch() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                toast("Buscar o texto" + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        };
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

        if (id == R.id.action_pesquisar){
            toast("Clicou em pesquisar");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
