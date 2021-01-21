package com.example.perpus.converter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeDeserializer implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String date = json.getAsJsonPrimitive().getAsString();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        try{
            return formatter.parse(date);
        } catch (ParseException e){
            try {
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.parse(date);
            } catch (ParseException el){

            }
        }
        return null;
    }
}
