package com.example.aps_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextNomeFruta, editTextPreco;
    Button buttonSalvar;
    Spinner spinnerMesColheita;
    List<String> listaFrutas;
    ArrayAdapter<String> adaptador;
    private List<String> mesColheita = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNomeFruta = (EditText) findViewById(R.id.editTextNomeFruta);
        editTextPreco = (EditText) findViewById(R.id.editTextPreco);
        spinnerMesColheita = (Spinner) findViewById(R.id.spinnerMesColheita);

        mesColheita.add("Janeiro");
        mesColheita.add("Fevereiro");
        mesColheita.add("Março");
        mesColheita.add("Abril");
        mesColheita.add("Maio");
        mesColheita.add("Junho");
        mesColheita.add("Julho");
        mesColheita.add("Agosto");
        mesColheita.add("Setembro");
        mesColheita.add("Outubro");
        mesColheita.add("Novembro");
        mesColheita.add("Dezembro");


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mesColheita);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinnerMesColheita);
        spinner.setAdapter(adapter);

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);

        listaFrutas = new ArrayList<String>();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaFrutas);

    }

    public void listarCadastro(View v) {
        String nomeFruta = editTextNomeFruta.getText().toString();
        Float precoFruta = Float.parseFloat(editTextPreco.getText().toString());

        if(nomeFruta.equals("") || precoFruta.equals("")) {
            Toast.makeText(this, "Preencha todos os campos para cadastrar!", Toast.LENGTH_SHORT).show();
        }else{
            listaFrutas.add("Nome da Fruta: " + nomeFruta + " \n" + "Preço da fruta: R$ " + String.format("%.2f", precoFruta) + "\n"
                    + "Mês da colheita: " + spinnerMesColheita.getSelectedItem().toString());
            Intent intent = new Intent(this, CadastroFrutas.class);
            intent.putStringArrayListExtra("LISTA_FRUTAS", (ArrayList<String>) listaFrutas);
            startActivity(intent);
        }
    }

}