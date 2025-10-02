package com.nunes;

public class Main {
    public static void main(String[] args) {
        int vetor[] = {1,4,2,7,9,5,6,4,4,9,0};
        int vetorO[] = {2,3,4,4,5,6,7};
        int elemento = 7;

        Pesquisa p = new Pesquisa();
        System.out.println(p.pesquisaSeqNOrdenada(vetor, elemento));
        System.out.println(p.pesquisaSeqOrdenada(vetorO, elemento));
        System.out.println(p.pesquisaBinaria(vetorO, elemento));
    }
}