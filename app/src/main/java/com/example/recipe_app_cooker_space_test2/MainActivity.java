package com.example.recipe_app_cooker_space_test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ArrayList<recyclerview_list> recyclerview_lists;
   Button modify_button ;
   RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerview_lists = new ArrayList<recyclerview_list>();
        recyclerview_lists.add(new recyclerview_list(R.drawable.image_card, "DishName1"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.image_card, "DishName2"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.image_card, "DishName3"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.image_card, "DishName4"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.image_card, "DishName5"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.image_card, "DishName6"));

        recyclerview_adapter recyclerview_adapter = new recyclerview_adapter(recyclerview_lists, this);
        recyclerView.setAdapter(recyclerview_adapter);

    }
}