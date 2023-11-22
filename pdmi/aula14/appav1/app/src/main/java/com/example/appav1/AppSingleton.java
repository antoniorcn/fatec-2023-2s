package com.example.appav1;

import java.util.HashMap;
import java.util.Map;

public class AppSingleton {

    private Map<String, Object> mapa = new HashMap<>();

    private static AppSingleton instance;

    private AppSingleton() {
    }

    public static AppSingleton getInstance() {
        if (instance == null) {
            instance = new AppSingleton();
        }
        return instance;
    }

    public void addAttribute(String chave, Object valor) {
        mapa.put(chave, valor);
    }

    public Object getAttribute(String chave) {
        return mapa.get(chave);
    }

}
