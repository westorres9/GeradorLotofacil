package com.westorres9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMegaSena = findViewById(R.id.buttonMegaSena);
        Button buttonLotofacil = findViewById(R.id.buttonLotofacil);

        buttonMegaSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarNumerosMegaSena();
            }
        });

        buttonLotofacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarNumerosLotofacil();
            }
        });
    }

    private void gerarNumerosMegaSena() {
        // Lógica para gerar números da Mega-Sena
        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();
        while (numeros.size() < 6) {
            int numero = random.nextInt(60) + 1; // Números vão de 1 a 60
            numeros.add(numero);
        }
        List<Integer> numerosList = new ArrayList<>(numeros);
        Collections.sort(numerosList);

        // Criando a mensagem com os números gerados
        StringBuilder mensagem = new StringBuilder("Números da Mega-Sena: ");
        for (int i = 0; i < numerosList.size(); i++) {
            mensagem.append(numerosList.get(i));
            if (i < numerosList.size() - 1) {
                mensagem.append(", ");
            }
        }

        Intent intent = new Intent(MainActivity.this, NumerosGeradosActivity.class);
        // Coloque os números gerados como extras na intent
        intent.putExtra("numerosGerados", "Números da Mega-Sena: " + numerosList); // Substitua pelos números gerados
        startActivity(intent);
    }

    private void gerarNumerosLotofacil() {
        // Lógica para gerar números da Lotofácil
        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();
        while (numeros.size() < 15) {
            int numero = random.nextInt(25) + 1; // Números vão de 1 a 25
            numeros.add(numero);
        }
        List<Integer> numerosList = new ArrayList<>(numeros);
        Collections.sort(numerosList);

        // Criando a mensagem com os números gerados
        StringBuilder mensagem = new StringBuilder("Números da Lotofácil: ");
        for (int i = 0; i < numerosList.size(); i++) {
            mensagem.append(numerosList.get(i));
            if (i < numerosList.size() - 1) {
                mensagem.append(", ");
            }
        }

        Intent intent = new Intent(MainActivity.this, NumerosGeradosActivity.class);
        // Coloque os números gerados como extras na intent
        intent.putExtra("numerosGerados", "Números da Lotofácil: " + numerosList); // Substitua pelos números gerados
        startActivity(intent);
    }
}