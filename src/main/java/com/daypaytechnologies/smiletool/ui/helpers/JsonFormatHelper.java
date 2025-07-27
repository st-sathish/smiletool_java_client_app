package com.daypaytechnologies.smiletool.ui.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonFormatHelper {

    public static String getPrettyJson(String rawJsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(rawJsonString);
        return gson.toJson(jsonElement);
    }
}
