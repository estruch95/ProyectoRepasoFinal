package com.example.estruch18.proyectorepasofinal;

import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActivityDatos extends Activity {
    //Atributos del Activity 2
    private TextView infoEdad, infoCarnet;
    private EditText nombre, apellidos, dni;
    private Switch carnet;
    private RadioGroup grupoSexo;
    private RadioButton rbHombre, rbMujer;
    private RatingBar valoracionApp;
    private SeekBar edad;
    private Button btnRestaurar, btnGuardar;

    private static final int ACTIVITY_INFO = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        //Declaración de atributos
        infoEdad = (TextView)findViewById(R.id.tvEdadInfo);
        infoCarnet= (TextView)findViewById(R.id.tvCarnetInfo);
        nombre = (EditText)findViewById(R.id.etNombre);
        apellidos = (EditText)findViewById(R.id.etApellidos);
        dni = (EditText)findViewById(R.id.etDni);
        carnet = (Switch)findViewById(R.id.swCarnet);
        grupoSexo = (RadioGroup)findViewById(R.id.rgSexo);
        rbHombre = (RadioButton)findViewById(R.id.rbHombre);
        rbMujer = (RadioButton)findViewById(R.id.rbMujer);
        valoracionApp = (RatingBar)findViewById(R.id.rbValoracion);
        edad = (SeekBar)findViewById(R.id.skEdad);
        btnRestaurar = (Button)findViewById(R.id.btnRestaurar);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);

        //Ejecución de métodos
        seleccionEdad();
        seleccionValoracion();
        seleccionCarnet();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_datos, menu);
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

    //Listeners de los botones del Activity 2
    public void accionBtnRestaurar(View v){
        this.btnRestaurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restauracionDatos();
                //Información
                Toast.makeText(getApplicationContext(), "Restauración correcta", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void accionBtnGuardar(View v){
        this.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadoDatos();
                Toast.makeText(getApplicationContext(), "Guardado correcto", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Método encargado de la restauración de todos los datos
    public void restauracionDatos(){
        //Restaurado de los campos de texto, y valores por defecto
        nombre.setText("");
        apellidos.setText("");
        dni.setText("");
        carnet.setChecked(false);
        infoCarnet.setText("");
        rbHombre.setChecked(true);
        valoracionApp.setRating(00);
        edad.setProgress(0);
        infoEdad.setText("0 años");
    }

    //Método encargado de realizar el guardado de datos y cambiar al ActivityInfo
    public void guardadoDatos(){
        Intent actInfo = new Intent(getApplicationContext(), ActivityInfo.class);
        actInfo.putExtra("nombre", nombre.getText().toString());
        actInfo.putExtra("apellidos", apellidos.getText().toString());
        actInfo.putExtra("dni", dni.getText().toString());
        actInfo.putExtra("edad", String.valueOf(edad.getProgress()));
        startActivityForResult(actInfo, ACTIVITY_INFO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case ACTIVITY_INFO:
                gestionActivityInfo(requestCode, data);
                break;
        }
    }

    //Método encargado de la gestión del ActivityInfo
    public void gestionActivityInfo(int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            ArrayList<String> datosObtenidos = data.getExtras().getStringArrayList("resultados");

            for(int z=0; z<datosObtenidos.size(); z++){
                Toast.makeText(getApplicationContext(), datosObtenidos.get(z), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Error en ActivityInfo", Toast.LENGTH_SHORT).show();
        }
    }

    //Método encargado de refrescar la selección de la barra de progreso
    public void seleccionEdad(){
        infoEdad.setText(String.valueOf(edad.getProgress())+" años");
        edad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                infoEdad.setText(String.valueOf(edad.getProgress())+" años");
                int edadSelect = edad.getProgress();

                if(edadSelect >= 0 && edadSelect <= 30){
                    Toast.makeText(getApplicationContext(), "Eres joven", Toast.LENGTH_SHORT).show();
                }
                else if(edadSelect >= 30 && edadSelect <= 60){
                    Toast.makeText(getApplicationContext(), "Eres adulto", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Eres anciano", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //Método encargado de refrescar la selección de la barra de progreso
    public void seleccionValoracion(){
        valoracionApp.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                float valoracion = valoracionApp.getRating();

                if (valoracion >= 0 && valoracion <= 2) {
                    Toast.makeText(getApplicationContext(), "Nivel bajo", Toast.LENGTH_SHORT).show();
                } else if (valoracion >= 2 && valoracion <= 4) {
                    Toast.makeText(getApplicationContext(), "Nivel intermedio", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Nivel avanzado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void seleccionCarnet(){
        carnet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(carnet.isChecked()){
                    infoCarnet.setText("Dispone de carnet");
                }
                else{
                    infoCarnet.setText("No dispone de carnet");
                }
            }
        });
    }
}
