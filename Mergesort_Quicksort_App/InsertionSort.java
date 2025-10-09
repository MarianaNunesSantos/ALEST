package com.nunes;
public class InsertionSort { // big O(n^2)
    public void sort (int vetor[]){
        for (int i=1; i<vetor.length; i++){
            int aux = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > aux){          //comparação e trocas sucessivas
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
    }

}
