package com.westorres9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumerosGeradosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros_gerados);

        RecyclerView recyclerViewNumeros = findViewById(R.id.recyclerViewNumeros);

        // Obter os números gerados do Intent extras
        String numerosGerados = getIntent().getStringExtra("numerosGerados");
        String[] numerosArray = numerosGerados.substring(numerosGerados.indexOf("[") + 1, numerosGerados.indexOf("]")).split(", ");
        List<Integer> numerosList = new ArrayList<>();
        for (String numero : numerosArray) {
            numerosList.add(Integer.parseInt(numero));
        }

        // Configurar o RecyclerView com um GridLayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6); // 6 itens por linha
        recyclerViewNumeros.setLayoutManager(layoutManager);

        // Configurar o Adapter
        NumerosAdapter adapter = new NumerosAdapter(numerosList);
        recyclerViewNumeros.setAdapter(adapter);

        Button buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a atividade atual e retorna à MainActivity
            }
        });
    }
}