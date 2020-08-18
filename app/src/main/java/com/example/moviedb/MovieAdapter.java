package com.example.moviedb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ExampleViewHolder> {
    private Result[] results;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public View menuView;
        public TextView mTextView1;
        public ImageView poster;
        public TextView releaseDate;
        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            menuView = itemView;
            mTextView1 = itemView.findViewById(R.id.movieName);
            poster = itemView.findViewById(R.id.poster);
            releaseDate = itemView.findViewById(R.id.releaseDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public void filterList(Result[] filteredList) {
        results = filteredList;
        notifyDataSetChanged();
    }

    public MovieAdapter(Result[] exampleList) {
        results = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movie, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Result currentItem = results[position];
        holder.mTextView1.setText(currentItem.getTitle());
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        holder.releaseDate.setText(simpleDateFormat.format(currentItem.getRelease_date()));
        Picasso.with(holder.menuView.getContext())
                .load("https://image.tmdb.org/t/p/w220_and_h330_face/" + currentItem.getPosterPath())
                .into(holder.poster);
    }
    @Override
    public int getItemCount() {
        return results.length;
    }
}

