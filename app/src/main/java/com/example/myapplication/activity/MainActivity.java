package com.example.myapplication.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.FilmAdapter;
import com.example.myapplication.domain.Film;
import com.example.myapplication.utils.serviсe.JSONService;
import com.example.myapplication.utils.serviсe.NetworkService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPoster;
    private FilmAdapter filmAdapter;
    private Switch switchSort;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            recyclerViewPoster = findViewById(R.id.tablePoster);
            switchSort = findViewById(R.id.switchSort);
            switchSort.setChecked(true);
        List<Film> films = new ArrayList<>();
            switchSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    try {
                        filmAdapter.setFilms(JSONService.getFilms(isChecked));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
            switchSort.setChecked(false);
            recyclerViewPoster.setLayoutManager((new GridLayoutManager(this, 2)));
            filmAdapter = new FilmAdapter();

        recyclerViewPoster.setAdapter(filmAdapter);

        }
    }
