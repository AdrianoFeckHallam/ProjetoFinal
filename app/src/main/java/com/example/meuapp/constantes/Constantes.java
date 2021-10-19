package com.example.meuapp.constantes;

public class Constantes {

    private static String chaveApi = "799a1f0649735842ab24e00e80ad2b30";

    public Constantes(String chaveApi) {
        this.chaveApi = chaveApi;
    }

   public static String getChaveApi() {
        return chaveApi;
    }
}
