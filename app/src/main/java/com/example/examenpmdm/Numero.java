package com.example.examenpmdm;

import java.util.ArrayList;

public class Numero {
    private int numeroRecibido;

    public Numero(int numeroRecibido)
    {
        this.numeroRecibido = numeroRecibido;
    }

    public int getNumeroRecibido() {
        return numeroRecibido;
    }

    public void setNumeroRecibido(int numeroRecibido) {
        this.numeroRecibido = numeroRecibido;
    }


    public int  calcularNumeros()
    {
        int contador = 0;
        for (int i=1; i<=numeroRecibido; i++)
        {
            if(numeroRecibido%i==0){
                contador ++;
            }
        }
        return contador;
    }

    public static ArrayList<Numero> createNumeroList(int numero)
    {
        ArrayList<Numero> numeros = new ArrayList<Numero>();

        for (int i = 1; i <= numero; i++)
        {
            if(numero%i == 0)
            numeros.add(new Numero(i));
        }

        return numeros;
    }
}