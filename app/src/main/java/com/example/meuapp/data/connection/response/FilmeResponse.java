package com.example.meuapp.data.connection.response;

import com.example.meuapp.data.model.Generos;
import com.squareup.moshi.Json;
import java.util.List;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "title")
    private final String tituloFilme;
    @Json(name="id")
    private final String idFilme;


    @Json(name="overview")
    private final String descricao;

    @Json(name="genres.name")
    private final String generos;


    public FilmeResponse(String caminhoPoster, String tituloFilme, String idFilme, String descricao, String generos) {
        this.caminhoPoster = caminhoPoster;
        this.tituloFilme = tituloFilme;
        this.idFilme = idFilme;
        this.descricao = descricao;
        this.generos = generos;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }
    public String getIdFilme(){return idFilme;}
    public String getDescricao() {
        return descricao;
    }
    public String getGeneros() {
        return generos;
    }

}
