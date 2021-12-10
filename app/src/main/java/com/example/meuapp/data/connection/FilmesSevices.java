package com.example.meuapp.data.connection;


import com.example.meuapp.data.connection.response.FilmesResult;
import com.example.meuapp.data.connection.response.GeneroResponse;
import com.example.meuapp.data.connection.response.GenerosResult;
import com.example.meuapp.data.connection.response.VideosResult;
import com.example.meuapp.data.model.Generos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
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

    @GET("search/movie")
    Call<FilmesResult> SearchFilmes(@Query("api_key") String chaveApi, @Query("language") String linguagem,
                                    @Query("query") String busca);

    @GET("movie/{id}")
    Call<GenerosResult> Genero(@Path("id") Integer id, @Query("api_key") String chaveApi,
                                @Query("language") String linguagem);
    @GET("movie/{id}/videos")
    Call<VideosResult> Video(@Path("id") Integer id, @Query("api_key") String chaveApi,
                             @Query("include_video_language") String include_v_language);
}
