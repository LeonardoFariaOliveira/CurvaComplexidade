package com.example.sorts.times;

import java.util.ArrayList;
import java.util.List;

import com.example.sorts.InsertionSort;

public class InsertionSortTime implements ITime {

    public List<Double> tabelaTempo;
    public List<Integer> tabelaTamanho;
    public int[][] arrays;
    public InsertionSort insertionSort;

    public InsertionSortTime(
        int[][] _arrays,
        InsertionSort _insertionSort
    ){
        this.tabelaTamanho = new ArrayList<>();
        this.tabelaTempo = new ArrayList<>();
        this.arrays = _arrays;
        this.insertionSort = _insertionSort;
    }

    @Override
    public void calcularTempo(){

        for (int i = 0; i < 19; i++) {

            double somaTempoTotal = 0;
           
            for(int j = 0; j < 30; j++){

                var tempoInicio = System.currentTimeMillis();
                this.insertionSort.sort(this.arrays[i]);
                var tempoFim = System.currentTimeMillis();
                var tempoTotal = tempoFim - tempoInicio;
                somaTempoTotal = (somaTempoTotal + tempoTotal);
            
            }

            double mediaTempoTotal = somaTempoTotal / 30;

            this.tabelaTempo.add(i, mediaTempoTotal);
            this.tabelaTamanho.add(this.arrays[i].length);
            
        }

    }

    @Override
    public void exibirTabelas(){
            
        System.out.println("### Insertion sort ###" );
        System.out.println("Entrada - Media de tempo" );

        for(int c=0; c<19; c++){
            
            System.out.print(this.tabelaTamanho.get(c));
            System.out.print(" - " );
            System.out.printf("%.2f %n", 
            this.tabelaTempo.get(c));
            
        }

    }

}
