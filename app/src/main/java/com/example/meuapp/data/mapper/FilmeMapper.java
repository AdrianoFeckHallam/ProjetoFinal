package com.example.meuapp.data.mapper;

import com.example.meuapp.data.connection.response.FilmeResponse;
import com.example.meuapp.data.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> responseToDomain(List<FilmeResponse> listaFilmeResponse){
         List<Filme> listaFilmes= new ArrayList<>();

         for(FilmeResponse filmeResponse : listaFilmeResponse){

                final Filme filme = new Filme(filmeResponse.getTituloFilme(), filmeResponse.getCaminhoPoster(), filmeResponse.getCaminhoBackground(), filmeResponse.getIdFilme(), filmeResponse.getDescricao(), filmeResponse.getGeneros(), filmeResponse.getGeneros_Id());
                listaFilmes.add(filme);

         }
         return listaFilmes;
    }
}
