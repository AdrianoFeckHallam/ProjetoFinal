package com.example.meuapp.data.connection.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "title")
    private final String tituloFilme;
    @Json(name="id")
    private final String idFilme;


    @Json(name="description")
    private final String descricao;

    public FilmeResponse(String caminhoPoster, String tituloFilme, String idFilme, String descricao) {
        this.caminhoPoster = caminhoPoster;
        this.tituloFilme = tituloFilme;
        this.idFilme = idFilme;
        this.descricao = descricao;
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

}
