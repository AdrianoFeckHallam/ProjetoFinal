package com.example.meuapp.data.mapper;

import com.example.meuapp.data.connection.response.GeneroResponse;
import com.example.meuapp.data.connection.response.VideoResponse;
import com.example.meuapp.data.model.Generos;
import com.example.meuapp.data.model.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoMapper {

    public static List<Video> responseToDomain(List<VideoResponse> listaVideoResponse){
        List<Video> listaVideos= new ArrayList<>();

        for(VideoResponse videoResponse : listaVideoResponse){

            final Video video = new Video(videoResponse.getIso1(), videoResponse.getIso2(), videoResponse.getVideoName(), videoResponse.getVideoKey(), videoResponse.getVideoSite(), videoResponse.getVideoSize(), videoResponse.getVideoType(), videoResponse.getVideoIsOfficial(), videoResponse.getVideoPublishedAt(), videoResponse.getVideoId());
            listaVideos.add(video);

        }
        return listaVideos;
    }
}
