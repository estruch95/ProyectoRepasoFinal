package com.example.estruch18.proyectorepasofinal;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;


public class Spinner extends Activity {

    //Atributos de la clase
    //SPINNERS LOCAL Y DINÁMICO
    private android.widget.Spinner spProvinciasLocal, spProvinciasDinamico;
    //SPINNERS CON CARGA DE DATOS MASIVA MEDIANTE TYPEDARRAY
    private android.widget.Spinner spProvincias, spPueblos;
    private ArrayList<String> provincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        //Declaración de atributos de la clase
        spProvinciasLocal = (android.widget.Spinner)findViewById(R.id.sp_ProvinciasLocal);
        spProvinciasDinamico = (android.widget.Spinner)findViewById(R.id.spProvinciasDinamico);
        spProvincias = (android.widget.Spinner)findViewById(R.id.spProvincias);
        spPueblos = (android.widget.Spinner)findViewById(R.id.spPueblos);

        //Ejecución de métodos
        spinnerLocal();
        spinnerDinamico();
        spinnerTypedArray();
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

    public void spinnerTypedArray(){
        //RELLENO DE DATOS EN spProvincias
        ArrayAdapter adaptadorProvincias = ArrayAdapter.createFromResource(this, R.array.provinciasEsp, android.R.layout.simple_spinner_item);
        adaptadorProvincias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProvincias.setAdapter(adaptadorProvincias);

        spProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Creación de un objeto TypedArray
                TypedArray pueblos = getResources().obtainTypedArray(R.array.array_provincia_a_localidades);
                String localidades[] = getResources().getStringArray(pueblos.getResourceId(position, 0));

                ArrayAdapter adaptadorPueblos = new ArrayAdapter(Spinner.this, android.R.layout.simple_spinner_item, localidades);
                adaptadorPueblos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spPueblos.setAdapter(adaptadorPueblos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Sin selección", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
