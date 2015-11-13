package com.example.estruch18.proyectorepasofinal;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Notificacion extends Activity {
    //Atributos de la clase
    private Button btnNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificacion);

        //Declaración de atributos de la clase
        btnNotificacion = (Button)findViewById(R.id.btnNotificacion);

        //Ejecución de métodos
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notificacion, menu);
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

    //Listener del botón
    public void accionBtnNotificacion(View v){
        //CREACION DE LA NOTIFICACIÓN
        Notification.Builder nb = new Notification.Builder(getApplicationContext());
        //TÍTULO
        nb.setContentTitle("ALERTA");
        //TEXTO
        nb.setContentText("El sistema se reiniciará en 10 minutos");
        nb.setSmallIcon(R.mipmap.ic_launcher);
        //COLOR FONDO
        nb.setColor(Color.RED);
        //SONIDO
        nb.setSound(Settings.System.DEFAULT_ALARM_ALERT_URI);
        //VIBRACIÓN
        nb.setVibrate(new long[]{1000, 1000});
        //BOTONES Y SUS ACCIONES
        //Acciones de los botones implementados en la notificación expandida
        Intent intentReiniciar = new Intent(getApplicationContext(), Activity1.class);
        Intent intentContinuar = new Intent();

        PendingIntent reiniciar = PendingIntent.getActivity(getApplicationContext(),0,intentReiniciar, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent continuar = PendingIntent.getActivity(getApplicationContext(),0,intentContinuar, PendingIntent.FLAG_UPDATE_CURRENT);

        nb.addAction(R.mipmap.ic_launcher, "Reiniciar", reiniciar);
        nb.addAction(R.mipmap.ic_launcher, "Continuar", continuar);

        //LA EXPANDIMOS
        Notification.InboxStyle ni= new Notification.InboxStyle();
        ni.addLine("Iván");
        ni.addLine("Estruch Belda");
        ni.addLine("22596425Y");
        ni.addLine("695391923");
        //APLICAMOS EL ESTILO DE NOTIFICACIÓN EXPANDIDA
        nb.setStyle(ni);

        //MOSTRAMOS LA NOTIFICACIÓN
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1, nb.build());
    }
}
