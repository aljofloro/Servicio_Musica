package com.desarrollo.serviciomusica;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ServicioMusica extends Service {

    MediaPlayer reproductor;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        reproductor = MediaPlayer.create(getApplicationContext(),R.raw.slipknot);
        Toast.makeText(getApplicationContext(),"Creando Servicio de Música",Toast.LENGTH_SHORT).show();
    }

    @Override
    public  int onStartCommand(Intent intent, int flags,int startId){
        Toast.makeText(this,"Servicio Arrancando"+startId,Toast.LENGTH_SHORT).show();
        reproductor.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this,"Servicio Detenido",Toast.LENGTH_SHORT).show();
        reproductor.stop();
    }


}
