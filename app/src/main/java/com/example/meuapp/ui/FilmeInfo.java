package com.example.meuapp.ui;

        import static java.lang.Integer.parseInt;

        import androidx.annotation.NonNull;
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
        import com.example.meuapp.data.connection.ApiService;
        import com.example.meuapp.data.connection.response.GenerosResult;
        import com.example.meuapp.data.connection.response.VideosResult;
        import com.example.meuapp.data.mapper.GeneroMapper;
        import com.example.meuapp.data.mapper.VideoMapper;
        import com.example.meuapp.data.model.Filme;
        import com.example.meuapp.data.model.Generos;
        import com.example.meuapp.data.model.Video;
        import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
        import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
        import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
        import com.squareup.picasso.Picasso;

        import org.jetbrains.annotations.NotNull;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

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


        ApiService.getInstance()
                .Genero(parseInt(filme.getIdFilme()),"799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<GenerosResult>() {
                    @Override
                    public void onResponse(@NotNull Call<GenerosResult> call, @NotNull Response<GenerosResult> response) {
                        if (response.isSuccessful()) {
                            final List<Generos> listaGeneros = GeneroMapper
                                    .responseToDomain(response.body().getResultados());
                            final Filme novoFilme = new Filme (filme.getTitulo(), filme.getCaminhoPoster(), filme.getCaminhoBackground(), filme.getIdFilme(), filme.getDescricao(), listaGeneros);
                            TextView txtGeneros = findViewById(R.id.txt_genders);
                            txtGeneros.setText(novoFilme.getNomeGenerosLinha());
                        } else {
                            Log.d("FilmeResponse","Erro ao adicionar generos: " + response);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<GenerosResult> call, Throwable t) {
                        Log.d("FilmeResponse","Erro ao adicionar generos: " + t.getMessage());
                    }
                });

        YouTubePlayerView youTubePlayerView = findViewById(R.id.player_trailer);
        getLifecycle().addObserver(youTubePlayerView);

        ApiService.getInstance()
                .Video(parseInt(filme.getIdFilme()), "799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<VideosResult>() {
                    @Override
                    public void onResponse(Call<VideosResult> call, Response<VideosResult> response) {
                        if (response.isSuccessful()) {
                            final List<Video> listaVideos = VideoMapper
                                    .responseToDomain(response.body().getResultados());
                            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                                @Override
                                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                                    if(listaVideos.size() != 0){
                                        String videoId = listaVideos.get(0).getKey_video();
                                        if(videoId != null){
                                            youTubePlayer.cueVideo(videoId, 0);
                                        }
                                    } else {
                                        youTubePlayer.cueVideo("DMxOk3AIAVU", 0);
                                    }
                                }
                            });
                        } else {
                            Log.d("FilmeResponse","Erro ao adicionar videos: " + response);
                        }
                    }

                    @Override
                    public void onFailure(Call<VideosResult> call, Throwable t) {
                        Log.d("FilmeResponse","Erro ao adicionar videos: " + t.getMessage());
                    }
                });

        TextView txtTitulo = findViewById(R.id.txt_nome_filme);
        TextView txtDesc = findViewById(R.id.txt_descricao_filme);

        ImageView imgFilme = findViewById(R.id.img_poster_filme);
        ImageView imgBackgroundFilme = findViewById(R.id.img_background_filme);
        txtTitulo.setText(filme.getTitulo());
        txtDesc.setText(filme.getDescricao());
        getLifecycle().addObserver(youTubePlayerView);

        Log.d("FilmeInfo", "Generos: " + filme.getGeneros());
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+filme.getCaminhoPoster())
                .into(imgFilme);
        Picasso.get().load("https://image.tmdb.org/t/p/original/"+filme.getCaminhoBackground()).into(imgBackgroundFilme);


    }

    public void retorna(View view) {
        startActivity(new Intent(getBaseContext(), ListaFilmesActivity.class));
    }
}