package com.example.examenpmdm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.examenpmdm.databinding.DivisoresActivityBinding;

import java.util.ArrayList;

public class DivisoresActivity extends AppCompatActivity implements View.OnClickListener ,NumeroAdapter.OnItemClickListener {
    ArrayList<Numero> numeros;
    private  DivisoresActivityBinding binding;
    private AlertDialog.Builder popup;
    private NumeroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DivisoresActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        this.popup=new AlertDialog.Builder(this);

        Bundle extras = getIntent().getExtras();
        int numero = extras.getInt("numero");

        Numero nuevoNumero = new Numero(numero);

        numeros = Numero.createNumeroList( numero);

        adapter = new NumeroAdapter(numeros);

        binding.rvContacts.setAdapter(adapter);

        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(this);



    }
    public void onClick(View v)
    {

    }


    public void onItemClick(View itemView, int position)
    {
        int numero = numeros.get(position).getNumeroRecibido();
        String numerosPrimos = "";
        for (int j = numero; numero >2;numero--)
        {
            for (int i = 2; i<= numero/2; i++)
                if(numero % i != 0)
                    numerosPrimos = (numerosPrimos + "   " + i);
        }
        popup.setTitle("titulo");
        popup.setMessage("numeros primos:" + numerosPrimos);
        popup.setPositiveButton("Ok", null);
        popup.show();
    }
}
