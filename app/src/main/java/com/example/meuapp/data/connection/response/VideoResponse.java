package com.example.meuapp.data.connection.response;

import android.util.Log;

import com.squareup.moshi.Json;


public class VideoResponse {
    @Json(name = "iso_639_1")
    private final String iso1;

    @Json(name = "iso_3166_1")
    private final String iso2;

    @Json(name = "name")
    private final String videoName;

    @Json(name = "key")
    private final String videoKey;

    @Json(name = "site")
    private final String videoSite;

    @Json(name = "size")
    private final String videoSize;

    @Json(name = "type")
    private final String videoType;

    @Json(name = "official")
    private final Boolean videoIsOfficial;

    @Json(name = "published_at")
    private final String videoPublishedAt;

    @Json(name = "id")
    private final String videoId;


    public VideoResponse(String iso1, String iso2, String videoName, String videoKey, String videoSite, String videoSize, String videoType, Boolean videoIsOfficial, String videoPublishedAt, String videoId) {
        this.iso1 = iso1;
        this.iso2 = iso2;
        this.videoName = videoName;
        this.videoKey = videoKey;
        this.videoSite = videoSite;
        this.videoSize = videoSize;
        this.videoType = videoType;
        this.videoIsOfficial = videoIsOfficial;
        this.videoPublishedAt = videoPublishedAt;
        this.videoId = videoId;
    }

    public String getIso1() {
        return iso1;
    }

    public String getIso2() {
        return iso2;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoKey() {
        return videoKey;
    }

    public String getVideoSite() {
        return videoSite;
    }

    public String getVideoSize() {
        return videoSize;
    }

    public String getVideoType() {
        return videoType;
    }

    public Boolean getVideoIsOfficial() {
        return videoIsOfficial;
    }

    public String getVideoPublishedAt() {
        return videoPublishedAt;
    }

    public String getVideoId() {
        return videoId;
    }
}
