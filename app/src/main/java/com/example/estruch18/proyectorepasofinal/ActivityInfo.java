package com.example.estruch18.proyectorepasofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class ActivityInfo extends Activity {
    //Atributos de la clase
    private EditText nombre, apellidos, dni, edad;
    private Button btnContinuar;
    private ArrayList<String> resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Declaración de atributos de la clase
        nombre = (EditText)findViewById(R.id.etInfoNombre);
        apellidos = (EditText)findViewById(R.id.etInfoApellidos);
        dni = (EditText)findViewById(R.id.etInfoDni);
        edad = (EditText)findViewById(R.id.etInfoEdad);
        btnContinuar = (Button)findViewById(R.id.btnContinuar);
        resultados = new ArrayList<String>();

        //Ejecución de métodos
        mostrarDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_info, menu);
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

    public void accionBtnContinuar(View v){
        this.btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActual = getIntent();
                intentActual.putStringArrayListExtra("resultados", almacenarDatos());
                setResult(RESULT_OK, intentActual);
                finish();
            }
        });
    }

    public ArrayList<String> almacenarDatos(){
        resultados.add(nombre.getText().toString());
        resultados.add(apellidos.getText().toString());
        resultados.add(dni.getText().toString());
        resultados.add(edad.getText().toString());
        return resultados;
    }

    public void mostrarDatos(){
        Bundle datos = getIntent().getExtras();
        nombre.setText(datos.getString("nombre"));
        apellidos.setText(datos.getString("apellidos"));
        dni.setText(datos.getString("dni"));
        edad.setText(datos.getString("edad"));
    }
}
