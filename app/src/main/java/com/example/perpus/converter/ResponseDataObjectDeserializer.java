package com.example.perpus.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

public class ResponseDataObjectDeserializer implements JsonDeserializer<ResponseDataObject<Object>>{

    private GsonBuilder gsonBuilder;

    @Override
    public ResponseDataObject<Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateTimeDeserializer());

        Gson gson = gsonBuilder.serializeNulls().create();
        return gson.fromJson(json, typeOfT);
    }
}
