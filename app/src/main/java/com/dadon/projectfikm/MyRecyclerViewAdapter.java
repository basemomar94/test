package com.dadon.projectfikm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Film> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<Film> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.film_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film film = mData.get(position);
        holder.title.setText(film.getTitle());
        holder.id.setText(film.getIdfilm());
        holder.language.setText("Lang : "+film.getLanguage());
        holder.rate.setText("Rate : "+ film.getRate().toString());

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, id, language, quot, rate;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titlem);
            id = itemView.findViewById(R.id.id);
            language = itemView.findViewById(R.id.language);
            rate = itemView.findViewById(R.id.rate);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

        }
    }

    void changelist(List<Film> searchList){
        mData = searchList;
        notifyDataSetChanged();

    }

    // convenience method for getting data at click position


    // allows clicks events to be caught


    // parent activity will implement this method to respond to click events

}