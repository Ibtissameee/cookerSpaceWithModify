package com.example.recipe_app_cooker_space_test2;

// CustomSpinnerAdapter.java

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomSpinnerAdapter extends ArrayAdapter<CharSequence> {

    public CustomSpinnerAdapter(Context context, int resource, CharSequence[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);

        // Change the color of the text for the first item
        if (position == 0) {
            ((TextView) view).setTextColor(Color.parseColor("#CDCBCB"));
        }

        return view;
    }
}
