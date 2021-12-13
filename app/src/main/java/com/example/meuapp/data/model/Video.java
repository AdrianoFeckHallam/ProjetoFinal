package com.example.meuapp.data.model;

import com.squareup.moshi.Json;

public class Video {

    private String iso_1;
    private String iso_2;
    private String nome_video;
    private String key_video;
    private String site_video;
    private String tamanho_video;
    private String tipo_video;
    private Boolean video_eh_oficial;
    private String data_publicacao;
    private String id_video;

    public Video(String iso_1, String iso_2, String nome_video, String key_video, String site_video, String tamanho_video, String tipo_video, Boolean video_eh_oficial, String data_publicacao, String id_video) {
        this.iso_1 = iso_1;
        this.iso_2 = iso_2;
        this.nome_video = nome_video;
        this.key_video = key_video;
        this.site_video = site_video;
        this.tamanho_video = tamanho_video;
        this.tipo_video = tipo_video;
        this.video_eh_oficial = video_eh_oficial;
        this.data_publicacao = data_publicacao;
        this.id_video = id_video;
    }

    public String getIso_1() {
        return iso_1;
    }

    public void setIso_1(String iso_1) {
        this.iso_1 = iso_1;
    }

    public String getIso_2() {
        return iso_2;
    }

    public void setIso_2(String iso_2) {
        this.iso_2 = iso_2;
    }

    public String getNome_video() {
        return nome_video;
    }

    public void setNome_video(String nome_video) {
        this.nome_video = nome_video;
    }

    public String getKey_video() {
        return key_video;
    }

    public void setKey_video(String key_video) {
        this.key_video = key_video;
    }

    public String getSite_video() {
        return site_video;
    }

    public void setSite_video(String site_video) {
        this.site_video = site_video;
    }

    public String getTamanho_video() {
        return tamanho_video;
    }

    public void setTamanho_video(String tamanho_video) {
        this.tamanho_video = tamanho_video;
    }

    public String getTipo_video() {
        return tipo_video;
    }

    public void setTipo_video(String tipo_video) {
        this.tipo_video = tipo_video;
    }

    public Boolean getVideo_eh_oficial() {
        return video_eh_oficial;
    }

    public void setVideo_eh_oficial(Boolean video_eh_oficial) {
        this.video_eh_oficial = video_eh_oficial;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getId_video() {
        return id_video;
    }

    public void setId_video(String id_video) {
        this.id_video = id_video;
    }
}
