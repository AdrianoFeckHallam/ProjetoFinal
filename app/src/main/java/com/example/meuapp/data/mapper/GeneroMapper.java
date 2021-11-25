package com.example.meuapp.data.mapper;

import com.example.meuapp.data.connection.response.GeneroResponse;
import com.example.meuapp.data.model.Generos;

import java.util.ArrayList;
import java.util.List;

public class GeneroMapper {

    public static List<Generos> responseToDomain(List<GeneroResponse> listaGeneroResponse){
        List<Generos> listaGeneros= new ArrayList<>();

        for(GeneroResponse generoResponse : listaGeneroResponse){

            final Generos genero = new Generos(generoResponse.getIdGenero(), generoResponse.getNomeGenero());
            listaGeneros.add(genero);

        }
        return listaGeneros;
    }
}
