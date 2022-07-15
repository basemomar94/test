package com.dadon.projectfikm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.dadon.projectfikm.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    MyRecyclerViewAdapter adapter;
    ArrayList<Film> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        movieList.add(new Film("333", "1125", "Le dernier empereur", "FR", 3));
        movieList.add(new Film("333", "1279", "Ere de glace", "FR", 5));
        movieList.add(new Film("333", "1487", "Maman j'ai rate l'avion", "FR", 5));
        movieList.add(new Film("333", "1979", "Le sixieme sens", "FR", 3));
        movieList.add(new Film("333", "1316", "Les uns les autres", "FR", 3));
        movieList.add(new Film("333", "1870", "Et si c'etait vrai...", "FR", 5));
        movieList.add(new Film("333", "1293", "Ma vie en kaleidoscope", "FR", 5));
        movieList.add(new Film("333", "1979", "Mystic river", "AN", 3));


        setupRv(movieList);
        showForum();
        cancel();
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onQueryTextChange(String s) {

                search(s.toLowerCase());
                return true;
            }
        });

    }

    void setupRv(ArrayList<Film> _list) {
        // set up the RecyclerView
        RecyclerView recyclerView = binding.movieRv;
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new MyRecyclerViewAdapter(MainActivity.this, _list);
        recyclerView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void search(String search) {
        ArrayList<Film> searchList = new ArrayList<>();

        for (Film element : movieList) {

            if (element.getIdfilm().contains(search) || element.getLanguage().toLowerCase().contains(search)) {
                searchList.add(element);
                System.out.println(element.getIdfilm());
            }

            setupRv(searchList);


        }

    }

    void showForum() {
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.addForume.setVisibility(View.VISIBLE);
                binding.movieRv.setAlpha(.2F);

                try {
                    addFilm();

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "please enter the data", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    void addFilm() {

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String id = binding.addID.getText().toString();
                    String title = binding.AddTitle.getText().toString();
                    String lang = binding.AddLang.getText().toString();
                    Integer rate = Integer.parseInt(binding.Addrate.getText().toString());
                    Film addedFilm = new Film("2", id, title, lang, rate);
                    movieList.add(addedFilm);
                    Toast.makeText(MainActivity.this, "Film " + id + " a été bien enregistré", Toast.LENGTH_LONG).show();
                   hideForum();
                    adapter.notifyDataSetChanged();
                    clearFields();


                } catch (Exception e) {
                    binding.addForume.setVisibility(View.GONE);
                    binding.movieRv.setAlpha(1F);
                    Toast.makeText(MainActivity.this, "please enter the data", Toast.LENGTH_LONG).show();

                }

            }
        });


    }

    void cancel(){
        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clearFields();
                hideForum();
            }
        });
    }

    void clearFields() {

        binding.addID.getText().clear();
        binding.AddTitle.getText().clear();
        binding.AddLang.getText().clear();
        binding.Addrate.getText().clear();
    }

    void hideForum(){
        binding.addForume.setVisibility(View.GONE);
        binding.movieRv.setAlpha(1F);
    }


}