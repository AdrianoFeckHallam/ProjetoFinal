package com.example.meuapp.data.connection.response;

import com.squareup.moshi.Json;

import java.util.List;

public class VideosResult {
    @Json(name="results")
        private final List<VideoResponse> resultado;

    public VideosResult(List<VideoResponse> resultado) {
        this.resultado = resultado;
    }

    public List<VideoResponse> getResultados() {
        return resultado;
    }
}
