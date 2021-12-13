package com.example.meuapp.data.model;

import com.squareup.moshi.Json;

public class Generos {
    // Classe model para o array dos generos dos filmes

    private String id;
    private String name;

    // Getters 'n' Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Constructor


    public Generos(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
