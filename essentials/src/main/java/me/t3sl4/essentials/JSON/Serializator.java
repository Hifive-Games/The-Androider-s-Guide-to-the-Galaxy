package me.t3sl4.essentials.JSON;

import com.google.gson.Gson;

public class Serializator {
    private final Gson gson;

    public Serializator() {
        this.gson = new Gson();
    }

    public String serialize(Object object) {
        return gson.toJson(object);
    }

    public <T> T deserialize(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }
}
