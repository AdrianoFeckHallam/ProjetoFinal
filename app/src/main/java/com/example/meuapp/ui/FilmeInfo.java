package com.example.meuapp.ui;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.nfc.Tag;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.meuapp.R;
        import com.example.meuapp.data.model.Filme;
        import com.squareup.picasso.Picasso;

public class FilmeInfo extends AppCompatActivity {
    public static  final String EXTRA_FILME = "EXTRA_FILME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Conecta();

        Button btnVoltar = findViewById(R.id.btnMenu);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retorna(view);
            }
        });


        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);
        TextView txtTitulo = findViewById(R.id.txt_nome_filme);
        TextView txtDesc = findViewById(R.id.txt_descricao_filme);
        TextView txtGeneros = findViewById(R.id.txt_genders);
        ImageView imgFilme = findViewById(R.id.img_poster_filme);
        String caminhoPoster;
        caminhoPoster = filme.getCaminhoPoster();
        txtTitulo.setText(filme.getTitulo());
        txtDesc.setText(filme.getDescricao());
        txtGeneros.setText(filme.getGeneros().toString());
        Log.d("FilmeInfo", "Generos: " + filme.getGeneros());
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+filme.getCaminhoPoster())
                .into(imgFilme);

    //
        /*new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(getBaseContext(), ListaFilmesActivity.class));
                finish();
            }
        },5000);*/


    }

    public void retorna(View view) {
        startActivity(new Intent(getBaseContext(), ListaFilmesActivity.class));
    }




}