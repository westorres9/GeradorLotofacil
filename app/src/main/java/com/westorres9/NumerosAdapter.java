package com.westorres9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NumerosAdapter extends RecyclerView.Adapter<NumerosAdapter.ViewHolder> {

    private List<Integer> numerosList;

    public NumerosAdapter(List<Integer> numerosList) {
        this.numerosList = numerosList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_numero_bolinha, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int numero = numerosList.get(position);
        holder.textViewNumero.setText(String.valueOf(numero));
    }

    @Override
    public int getItemCount() {
        return numerosList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNumero;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumero = itemView.findViewById(R.id.textViewNumero);
        }
    }
}