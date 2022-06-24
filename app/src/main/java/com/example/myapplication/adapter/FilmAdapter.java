package com.example.myapplication.adapter;

import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.domain.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private List<Film> films;

    public FilmAdapter(){
        this.films = new ArrayList<>();
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_film_item, viewGroup, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Film film = films.get(position);
        ImageView imageView = holder.customSmallPoster;
        Picasso.get().load(film.getPosterUrl()).into(imageView);
        TextView rate = holder.rate;
        rate.setText(film.getRatingKinopoisk());
        TextView nameRu = holder.nameRu;
        nameRu.setText(film.getNameRu());
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    class FilmViewHolder extends RecyclerView.ViewHolder{

        private ImageView customSmallPoster;
        private TextView nameRu;
        private TextView rate;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            customSmallPoster = itemView.findViewById(R.id.custom_small_poster);
            nameRu = itemView.findViewById(R.id.nameRu);
            rate = itemView.findViewById(R.id.rate);
        }
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilms(List<Film> films){
        this.films.addAll(films);
        notifyDataSetChanged();
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }
}
