package com.example.meuapp.data.model;

import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.meuapp.data.connection.ApiService;
import com.example.meuapp.data.connection.response.FilmesResult;
import com.example.meuapp.data.connection.response.GenerosResult;
import com.example.meuapp.data.mapper.FilmeMapper;
import com.example.meuapp.data.mapper.GeneroMapper;
import com.example.meuapp.ui.FilmeInfo;
import com.example.meuapp.ui.ListaFilmesActivity;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Filme implements Serializable {
    private String titulo;
    private String caminhoPoster;
    private ImageView poster;
//    private String generos;
    private List<Integer> generos_id;
    private List<Generos> generos;
    private String descricao;
    private String caminhoBackground;





    public String getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }

    private String idFilme;
    public Filme(String titulo, String caminhoPoster, String caminhoBackground, String idFilme, String descricao, List<Generos> generos, List<Integer> generos_id) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
        this.caminhoBackground = caminhoBackground;
        this.idFilme = idFilme;
        this.descricao = descricao;
        this.generos_id = generos_id;
        this.generos = generos;
    }
    //constructor para pegar os generos no FilmeInfo
    public Filme(String titulo, String caminhoPoster, String caminhoBackground, String idFilme, String descricao, List<Generos> generos){
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
        this.caminhoBackground = caminhoBackground;
        this.idFilme = idFilme;
        this.descricao = descricao;
        this.generos = generos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ImageView getPoster() {
        return poster;
    }

    public void setPoster() {
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+caminhoPoster)
                .into(this.poster);
    }
    public String getDescricao() {
        return descricao;
    }

    public List<Generos> getGeneros() {
        return generos;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public void setGeneros(List<Generos> generos){
        this.generos = generos;
    }
    public List<Integer> getGeneros_Id() {
        return generos_id;
    }

    public String getCaminhoBackground() {
        return caminhoBackground;
    }

    public void setCaminhoBackground(String caminhoBackground) {
        this.caminhoBackground = caminhoBackground;
    }

    public String getNomeGenerosLinha() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < getGeneros().size(); i++){
            if(i == getGeneros().size()-1) {
                temp.append(getGeneros().get(i).getName()).append(" ");
            } else if(i >= 0 && i < getGeneros().size()) {
                temp.append(getGeneros().get(i).getName()).append(", ");
            }

        }
        return temp.toString();
    }

}
