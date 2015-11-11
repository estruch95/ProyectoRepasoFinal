package com.example.estruch18.proyectorepasofinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class Spinner extends Activity {

    //Atributos de la clase
    private android.widget.Spinner spProvinciasLocal, spProvinciasDinamico;
    private ArrayList<String> provincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        //Declaración de atributos de la clase
        spProvinciasLocal = (android.widget.Spinner)findViewById(R.id.sp_ProvinciasLocal);
        spProvinciasDinamico = (android.widget.Spinner)findViewById(R.id.spProvinciasDinamico);

        //Ejecución de métodos
        spinnerLocal();
        spinnerDinamico();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spinner, menu);
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

    public void spinnerLocal(){
        provincias = new ArrayList<String>();
        provincias.add("Valencia");
        provincias.add("Madrid");
        provincias.add("Barcelona");
        provincias.add("Alicante");
        provincias.add("Murcia");

        ArrayAdapter adaptadorLocal = new ArrayAdapter(this, android.R.layout.simple_spinner_item, provincias);
        adaptadorLocal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProvinciasLocal.setAdapter(adaptadorLocal);
    }

    public void spinnerDinamico(){
        ArrayAdapter adaptadorDinamico = ArrayAdapter.createFromResource(this, R.array.provincias, android.R.layout.simple_spinner_item);
        adaptadorDinamico.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProvinciasDinamico.setAdapter(adaptadorDinamico);
    }
}
