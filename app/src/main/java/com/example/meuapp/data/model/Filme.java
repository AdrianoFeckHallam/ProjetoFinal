package com.example.meuapp.data.model;

import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Filme implements Serializable {
    private String titulo;
    private String caminhoPoster;
    private ImageView poster;



    private String descricao;

    public String getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }

    private String idFilme;
    public Filme(String titulo, String caminhoPoster, String idFilme, String descricao) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
        this.idFilme = idFilme;
        this.descricao = descricao;
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

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
}
