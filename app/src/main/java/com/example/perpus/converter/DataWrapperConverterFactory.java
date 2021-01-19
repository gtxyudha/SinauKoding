package com.example.perpus.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class DataWrapperConverterFactory extends Converter.Factory{

    private GsonBuilder gsonBuilder;
    private Gson gson;

    public DataWrapperConverterFactory(){
        super();

        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateTimeDeserializer());
        gsonBuilder.registerTypeAdapter(ResponseDataList.class, new ResponseDataListDeserializer());
        gsonBuilder.registerTypeAdapter(ResponseDataObject.class, new ResponseDataObjectDeserializer());

        gson = gsonBuilder.create();


    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new Converter<ResponseBody, Object>() {
            @Override
            public Object convert(ResponseBody value) throws IOException {
                return gson.fromJson(value.string(), type);
            }
        };
    }


    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new Converter<Object, RequestBody>() {
            @Override
            public RequestBody convert(Object value) throws IOException {
                String json = gson.toJson(value, type);

                return RequestBody.create(MediaType.parse("application/json"), json);
            }
        };
    }


}
