package com.example.recipe_app_cooker_space_test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ModifyRecipeActivity extends AppCompatActivity {

    private List<Recipe> recipesList;
    private ArrayAdapter<String> ingredientsAdapter;
    private ArrayAdapter<String> stepsAdapter;
    private RecyclerView ingredientsRecyclerView;
    private RecyclerView stepsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_recipe);


        // Spinner setup
        Spinner categorySpinner = findViewById(R.id.categorySpinner);

        // Use the custom adapter
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(
                this,
                android.R.layout.simple_spinner_item,
                getResources().getTextArray(R.array.categories)
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        categorySpinner.setAdapter(adapter);

        // Select the first element of the Spinner
        categorySpinner.setSelection(0);
    }

    private void showModifyDialog(final ArrayAdapter<String> adapter, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modify Item");

        // Set up the input
        final EditText input = new EditText(this);
        input.setText(adapter.getItem(position));
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newText = input.getText().toString();
                adapter.remove(adapter.getItem(position));
                adapter.insert(newText, position);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}