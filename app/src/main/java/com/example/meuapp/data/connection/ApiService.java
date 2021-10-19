package com.example.meuapp.data.connection;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {
    private static FilmesSevices Instance;
    public static FilmesSevices getInstance(){
        if(Instance==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
            Instance = retrofit.create(FilmesSevices.class);
        }
        return Instance;
    }
}
