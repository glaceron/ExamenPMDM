package com.example.examenpmdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenpmdm.databinding.ItemNumeroBinding;

import java.util.List;

public class NumeroAdapter extends RecyclerView.Adapter<NumeroAdapter.MyViewHolder>
{
    private List<Numero> mNumero;

    public interface OnItemClickListener
    {
        void onItemClick(View itemView, int position);
    }

    private OnItemClickListener listener;
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Pass in the contact array into the constructor
    public NumeroAdapter(List<Numero> numeros) {
        mNumero = numeros;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemNumeroBinding binding;//Name of the item_contact.xml in camel case + "Binding"

        public MyViewHolder(ItemNumeroBinding b) {
            super(b.getRoot());
            binding = b;
        }

        @Override
        public void onClick(View view) {
            // Triggers click upwards to the adapter on click
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(itemView, position);
                }
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new MyViewHolder(ItemNumeroBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Get the data model based on position
        Numero numero = mNumero.get(position);

        holder.binding.numeroPrimo.setText(String.valueOf(numero.getNumeroRecibido()));

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mNumero.size();
    }
}

