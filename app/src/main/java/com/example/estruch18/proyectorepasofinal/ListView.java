package com.example.estruch18.proyectorepasofinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class ListView extends Activity {
    //Atributos de la clase
    private android.widget.ListView lvProvincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        //Declaración de atributos de la clase
        lvProvincias = (android.widget.ListView)findViewById(R.id.lv_Provincias);

        //Ejecución de métodos
        cargadoDatos();
        getSeleccionProv();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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

    //Método encargado de realizar la carga de datos en el listview
    public void cargadoDatos(){
        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.provinciasEsp, android.R.layout.simple_list_item_1);
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        lvProvincias.setAdapter(adaptador);
    }

    //Mñetodo encargado de obtener la selección del listview
    public void getSeleccionProv(){
        lvProvincias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Has seleccionado una provincia", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
