package com.guriarte.cryptocurrencyconverter.mappers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonMapper<T> {

    private final Gson gson;
    private final Class<T> clazz;
    private final Type listClazz;

    public JsonMapper(Class<T> clazz) {
        this.gson = new Gson();
        this.clazz = clazz;
        this.listClazz = TypeToken.getParameterized(List.class, clazz).getType();
    }

    public T fromJson(String json) {
        return this.gson.fromJson(json, clazz);
    }

    public List<T> fromArrayJson(String arrayJson) {
        return this.gson.fromJson(arrayJson, listClazz);
    }

    public String toJson(T obj) {
        return this.gson.toJson(obj);
    }

}
