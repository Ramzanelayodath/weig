package com.example.weightedexample;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;


public class CustomGsonBuilder {
    static Gson customGson = null;
    public static Gson getGson() {
        if(customGson != null)
            return customGson;
        GsonBuilder builder = new GsonBuilder();
        ExclusionStrategy strategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                switch (f.getName()) {
                    case "id":
                     // No need of sending this in product line.
                        return true;
                    case "description":
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };


        builder.addSerializationExclusionStrategy(strategy);

        // Register an adapter to manage the date types as long values
        // https://stackoverflow.com/questions/5671373/unparseable-date-1302828677828-trying-to-deserialize-with-gson-a-millisecond
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        // To manage serialization of tags
       // builder.registerTypeAdapterFactory(new ProductLineTypeAdapterFactory());

        return builder.create();
    }

    public static Gson getGsonWithExposeFilter() {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        return builder.create();
    }

 }
