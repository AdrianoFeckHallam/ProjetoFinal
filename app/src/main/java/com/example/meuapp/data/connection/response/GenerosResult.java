package com.example.meuapp.data.connection.response;

import com.squareup.moshi.Json;

import java.util.List;

public class GenerosResult {
    @Json(name="genres")
    private final List<GeneroResponse> resultado;

    public GenerosResult(List<GeneroResponse> resultado) {
        this.resultado = resultado;
    }

    public List<GeneroResponse> getResultados() {
        return resultado;
    }
}
