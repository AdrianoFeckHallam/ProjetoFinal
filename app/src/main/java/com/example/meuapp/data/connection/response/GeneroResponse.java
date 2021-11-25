package com.example.meuapp.data.connection.response;

import android.util.Log;

import com.squareup.moshi.Json;


public class GeneroResponse {
    @Json(name = "id")
    private final String idGenero;

    @Json(name = "name")
    private final String nomeGenero;


    public GeneroResponse(String idGenero, String nomeGenero) {
        this.idGenero = idGenero;
        this.nomeGenero = nomeGenero;
        Log.d("GeneroResponse","idGenero: " + idGenero);
    }


    public String getIdGenero() {
        return idGenero;
    }
    public String getNomeGenero(){
        return nomeGenero;
    }
}
