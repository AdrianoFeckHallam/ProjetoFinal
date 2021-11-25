package com.example.meuapp.data.connection.response;

import android.util.Log;

import com.example.meuapp.data.connection.ApiService;
import com.example.meuapp.data.mapper.GeneroMapper;
import com.example.meuapp.data.model.Generos;
import com.squareup.moshi.Json;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "title")
    private final String tituloFilme;
    @Json(name="id")
    private final String idFilme;


    @Json(name="overview")
    private final String descricao;

    @Json(name="genre_ids")
    private final List<Integer> generos_id;

    @Json(name="backdrop_path")
    private final String caminhoBackground;

    private List<Generos> generos;


    public FilmeResponse(String caminhoPoster, String caminhoBackground, String tituloFilme, String idFilme, String descricao, List<Integer> generos_id, List<Generos> generos) {
        this.caminhoPoster = caminhoPoster;
        this.caminhoBackground = caminhoBackground;
        this.tituloFilme = tituloFilme;
        this.idFilme = idFilme;
        this.descricao = descricao;
        this.generos_id = generos_id;
        this.generos = generos;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
    public String getCaminhoBackground(){
        return caminhoBackground;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }
    public String getIdFilme(){return idFilme;}
    public String getDescricao() {
        return descricao;
    }
    public List<Integer> getGeneros_Id() {
        return generos_id;
    }
    public List<Generos> getGeneros(){
        return generos;
    }
}
