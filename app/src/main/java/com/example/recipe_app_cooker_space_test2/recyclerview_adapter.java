package com.example.recipe_app_cooker_space_test2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview_adapter extends RecyclerView.Adapter<recyclerview_adapter.ViewHolder> {
    private ArrayList<recyclerview_list> recyclerview_lists;
    private Context context;

    public recyclerview_adapter(ArrayList<recyclerview_list> recyclerview_lists, Context context) {
        this.recyclerview_lists = recyclerview_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public recyclerview_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerview_adapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(recyclerview_lists.get(position).getImage());
        holder.textView.setText(recyclerview_lists.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return recyclerview_lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button modifyButton;
        Button deleteButton;
        ImageView closeIcon ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            modifyButton = itemView.findViewById(R.id.modifyButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);



            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDeleteDialog();
                }
            });


            modifyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Create an Intent to start the second activity
                    Intent intent = new Intent(context, ModifyRecipeActivity.class);

                    // Start the second activity
                    context.startActivity(intent);
                }
            });



        }

        private void showDeleteDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View dialogView = LayoutInflater.from(context).inflate(R.layout.delete_confirmation_dialog, null);
            builder.setView(dialogView);

            TextView dialogText = dialogView.findViewById(R.id.delete_confirmation_message);
            Button dialogYesButton = dialogView.findViewById(R.id.yesButton);
            Button dialogNoButton = dialogView.findViewById(R.id.noButton);
            ImageView closeIcon = dialogView.findViewById(R.id.closeButton);

            dialogText.setText("Do you really want to delete the recipe?");

            AlertDialog dialog = builder.create();


            dialogYesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Delete the recipe from the database
                    // Call a method to delete the recipe
                    deleteRecipe(getAdapterPosition());
                    dialog.dismiss();
                }
                    });
            dialogNoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            closeIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

        private void deleteRecipe(int position) {
            // Remove the item from the list
            recyclerview_lists.remove(position);
            // Notify the adapter that the data set has changed
            notifyItemRemoved(position);
        }
    }
}