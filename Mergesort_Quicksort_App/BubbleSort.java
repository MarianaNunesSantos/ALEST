package com.nunes;

public class BubbleSort {   // big O(n^2)
    public void sort (int vetor[]){
            for (int i=0 ; i<vetor.length ; i++){
                boolean troca = false;
                for (int j=0 ; j<vetor.length -1 ; j++){
                    if (vetor[j] > vetor[j+1]){
                        int aux = vetor[j];
                        vetor[j] = vetor[j+1];
                        vetor[j+1] = aux;
                        troca = true;
                    }
                }
                if (!troca){
                    break;//para ver se trocou e se n trocou n precisa continuar o for
                }
            }
        }

}
