package com.nunes;

public class Pesquisa {
    public boolean pesquisaSeqNOrdenada(int vetor[], int elemento){
        for(int i=0; i<vetor.length; i++){
            if (vetor[i] == elemento){
                return true;
            }
        }
        return false;
    }

    public boolean pesquisaSeqOrdenada(int vetor[], int elemento){
        for(int i=0; i<vetor.length; i++){
            if (vetor[i] == elemento){
                return true;
            } else if (vetor[i] > elemento){
                return false;
            }
        }
        return false;
        
    }

    public boolean pesquisaBinaria(int vetor[], int elemento){
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim){
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == elemento){
                return true;
            } else if (vetor[meio] < elemento){
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return false;
    }

}

