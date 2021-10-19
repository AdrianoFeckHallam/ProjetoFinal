package com.example.meuapp.data.connection;


import com.example.meuapp.data.connection.response.FilmesResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface FilmesSevices {

    @GET("movie/popular")
    Call<FilmesResult> FilmesPopulares(@Query("api_key") String chaveApi,
                              @Query("language") String linguagem);
    @GET("movie/now_playing")
    Call<FilmesResult> FilmesReproduzidos(@Query("api_key") String chaveApi,
                                    @Query("language") String linguagem);
    @GET("movie/top_rated")
    Call<FilmesResult> FilmesBemAvaliados(@Query("api_key") String chaveApi,
                                      @Query("language") String linguagem);

    @GET("movie/")
    Call<FilmesResult> Filme(@Query("movie_id") String id,@Query("api_key") String chaveApi,
                                @Query("language") String linguagem);
}
