package com.example.estruch18.proyectorepasofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;


public class Activity1 extends Activity {
    //Atributos del Activity 1
    private Button btnDatos, btnListView, btnSpinner, btnNotificacion, btnLvMod, btnSpMod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        //Declaración de atributos del Activity 1
        btnDatos = (Button)findViewById(R.id.btnDatos);
        btnListView = (Button)findViewById(R.id.btnListView);
        btnSpinner = (Button)findViewById(R.id.btnSpinner);
        btnNotificacion = (Button)findViewById(R.id.btnNotificacion);
        btnLvMod = (Button)findViewById(R.id.btnLvMod);
        btnSpMod = (Button)findViewById(R.id.btnSpMod);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
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

    //Listeners de los botones del Activity 1:

    public void accionBtnDatos(View v){
        Intent actDatos = new Intent(getApplicationContext(), ActivityDatos.class);
        startActivity(actDatos);
    }

    public void accionBtnListView(View v){
        Intent actListView = new Intent(getApplicationContext(), ListView.class);
        startActivity(actListView);
    }

    public void accionBtnSpinner(View v){
        Intent actSpinner = new Intent(getApplicationContext(), Spinner.class);
        startActivity(actSpinner);
    }

    public void accionBtnNotificacion(View v){

    }

    public void accionBtnLvMod(View v){

    }

    public void accionBtnSpMod(View v){

    }
}
