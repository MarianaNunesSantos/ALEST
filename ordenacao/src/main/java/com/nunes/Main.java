package com.nunes;

public class Main {
    public static void main(String[] args) {
        int vetor[] = {85,24,63,45,17,31,96,50};
        for (int i=0; i<vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
        InsertionSort is = new InsertionSort();   //teste insertion sort
        is.sort(vetor);
        for (int i=0; i<vetor.length; i++){
            System.out.print(vetor[i] + " ");
        }    
    }
}