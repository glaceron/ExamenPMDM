package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.examenpmdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ActivityMainBinding binding;
    int code = 1;
    public static final String RESULTADO = "resultado";
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonMostrar.setOnClickListener(this);
        binding.buttonAbrirVentana.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        if (view == binding.buttonAbrirVentana) {
            intent = new Intent(this, DivisoresActivity.class);
            Bundle extras = new Bundle();
            try
            {
                extras.putInt("numero", Integer.parseInt(String.valueOf(binding.editTextNumeroIntroducido.getText())));
                intent.putExtras(extras);
                startActivity(intent);
            }
            catch (Exception e)
            {
                Toast.makeText(MainActivity.this, "Introduce un numero valido",Toast.LENGTH_SHORT).show();
            }

        }
        if(view == binding.buttonMostrar)
        {
            try
            {
                int numeroIntroducido = Integer.parseInt(String.valueOf(binding.editTextNumeroIntroducido.getText()));
                String divisores = "";
                for (int i=1; i<=numeroIntroducido; i++){
                    if(numeroIntroducido%i==0){
                        divisores = (divisores + "  " + i);
                    }
                }
                binding.textViewDivisores.setText(divisores);
            }
            catch (Exception e)
            {
                Toast.makeText(MainActivity.this, "Introduce un numero valido",Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
