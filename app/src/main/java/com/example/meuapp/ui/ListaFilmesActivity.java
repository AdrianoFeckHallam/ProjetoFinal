package com.example.meuapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.R;
import com.example.meuapp.data.connection.ApiService;
import com.example.meuapp.data.connection.response.FilmesResult;
import com.example.meuapp.data.mapper.FilmeMapper;
import com.example.meuapp.data.model.Filme;
import com.example.meuapp.data.model.Generos;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity implements SensorEventListener,
        ListaFilmesAdapter.ItemFilmeClickListener {
    SensorManager sensorManager;
    Sensor sensor;
    long TempoEvento;
    private static final int SOLICITAR_PERMISSAO = 1;
    private ListaFilmesAdapter FilmeAdapter1 = new ListaFilmesAdapter(this);
    private ListaFilmesAdapter FilmeAdapter2 = new ListaFilmesAdapter(this);
    private ListaFilmesAdapter FilmeAdapter3 = new ListaFilmesAdapter(this);
    RecyclerView rv1;
    RecyclerView rv2;
    RecyclerView rv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);


        obtemFilmes();

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(sensor == null){
            Log.e("Sensor","Sensor nao encontrado!" );
        }
    }
    @Override
    protected  void onResume(){
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void retorna(View view) {
        startActivity(new Intent(getBaseContext(), ListaFilmesActivity.class));
    }

    public void configuraAdapter() {
        rv1 = findViewById(R.id.rv_populares);
        rv2 = findViewById(R.id.rv_reproduzindo);
        rv3 = findViewById(R.id.rv_bem_avaliados);

        RecyclerView.LayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv1.setLayoutManager(linearLayoutManager1);
        rv2.setLayoutManager(linearLayoutManager2);
        rv3.setLayoutManager(linearLayoutManager3);
        rv1.setAdapter(FilmeAdapter1);
        rv2.setAdapter(FilmeAdapter2);
        rv3.setAdapter(FilmeAdapter3);
    }

    private void obtemFilmes() {
        ApiService.getInstance()
                .FilmesPopulares( "799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            Log.d("ListaFilmesActivity", "onResponse: Server Response: " + response.toString());
                            Log.d("ListaFilmesActivity", "onResponse: Received Info: " + response.body().getResultados().toString());

                            final List<Filme> listaFilmes = FilmeMapper
                                    .responseToDomain(response.body().getResultados());
                            FilmeAdapter1.setFilmes(listaFilmes);;

                            configuraAdapter();
                        } else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });
        ApiService.getInstance()
                .FilmesReproduzidos( "799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .responseToDomain(response.body().getResultados());

                            FilmeAdapter2.setFilmes(listaFilmes);

                            configuraAdapter();
                        } else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });
        ApiService.getInstance()
                .FilmesBemAvaliados("799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            Log.d("ListaFilmesActivity", "GENERO: " + response.body().getResultados().toArray());
                            final List<Filme> listaFilmes = FilmeMapper
                                    .responseToDomain(response.body().getResultados());

                            FilmeAdapter3.setFilmes(listaFilmes);

                            configuraAdapter();
                        } else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });

    }

    private void mostraErro() {
        Toast.makeText(this, "Falha na comunicaçao da api", Toast.LENGTH_SHORT)
                .show();
    }

    public void Share(View view) {
        String id;

        //TextView tv = (TextView) view.findViewById(R.id.tv_ml);
        //tv.getText().toString();
        TextView idText = ((View) view.getParent()).findViewById(R.id.txt_id);
        ImageView imageView = ((View) view.getParent()).findViewById(R.id.poster_filme);
        id = idText.getText().toString();

        System.out.println(id);
        String mensagem = "Se liga nesse filme http://filmes.uniritter.edu.br/filme?id="+id+"&de=Emerson";
        checarPermissao(mensagem, imageView);



    }
    private void checarPermissao(String msg, ImageView img) {

        // Verifica  o estado da permissão de WRITE_EXTERNAL_STORAGE
        int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);


        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            // Se for diferente de PERMISSION_GRANTED, então vamos exibir a tela padrão
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, SOLICITAR_PERMISSAO);
        } else {
            // Senão vamos compartilhar a imagem
            enviarWhatsApp(msg, img);
        }

    }

    public void enviarWhatsApp(String mensagem, ImageView image) {
        PackageManager pm = getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("*/*");
            String text = mensagem;
            BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
            Bitmap b = drawable.getBitmap();
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String path = MediaStore.Images.Media.insertImage(getContentResolver(), b, "shareImage", null);
            Uri uri = Uri.parse(path);

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            waIntent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(waIntent);

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp não instalado", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
            if(event.sensor == sensor && event.timestamp - TempoEvento>2000){
                String d = "";
                float x,y,z;
                x= event.values[0];
                y= event.values[1];
                z= event.values[2];
                for(float f : event.values){
                    d+=f+", ";
                }
                if(y>2){
                    Log.d("Sensor1", d);
                    rv1.scrollBy(300,0);
                }
                    if(y<2 && y!=0){
                        if(rv1 != null){

                            Log.d("Sensor2", d);
                            rv1.scrollBy(-300,0);
                        }
                    }



                if(z>2){

                    Log.d("Sensor3", d);
                    rv2.scrollBy(300,0);
                }

                    if(z<2 && z!=0){
                            if(rv2!=null){
                            Log.d("Sensor4", d);
                            rv2.scrollBy(-300,0);

                            }
                    }



            }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onItemFilmeClicado(Filme filme) {
        Intent intent = new Intent(this, FilmeInfo.class);
        intent.putExtra(FilmeInfo.EXTRA_FILME, filme);
        startActivity(intent);
    }
}


