package com.example.meuapp.data.model;

public class Generos {
    // Classe model para o array dos generos dos filmes

    private int id;
    private String name;

    // Getters 'n' Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Constructor


    public Generos(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
