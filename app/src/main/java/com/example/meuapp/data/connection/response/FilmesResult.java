package com.example.meuapp.data.connection.response;

import com.squareup.moshi.Json;

import java.util.List;

public class FilmesResult {
    @Json(name="results")
    private final List<FilmeResponse> resultados;

    public FilmesResult(List<FilmeResponse> resultados) {
        this.resultados = resultados;
    }

    public List<FilmeResponse> getResultados() {
        return resultados;
    }
}
