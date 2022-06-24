package com.example.myapplication.utils.serviсe;

import com.example.myapplication.domain.Film;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JSONService {

    public static List<Film> getFilms(Boolean isRate) throws JSONException {
        JSONObject jsonObject = NetworkService.getJSONFromNetwork(isRate);
        assert jsonObject != null;
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        List<Film> films = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++)
            films.add(new Film((JSONObject) jsonArray.get(i)));
        return films;
    }
}
