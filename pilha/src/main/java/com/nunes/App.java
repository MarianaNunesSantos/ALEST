package com.nunes;
public class App {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        
//        int tam = p.size();
//        for(int i=0; i<tam; i++) {
//            System.out.println(p.pop());
//        }
// OU        
        while(!p.isEmpty()) {
            System.out.println(p.pop());
        }
        
        
    }
    
    // recebe o vetor preenchido e inverte os valores do vetor.
    // exemplo: vetor original 1 2 3 4  vetor invertido 4 3 2 1
    // ==> utilizar pilhas para realizar a inversão
    public static void inverte(Integer vet[]) {
        Pilha aux = new Pilha();
        for (int i = 0; i < vet.length; i++) {
            aux.push(vet[i]);
            vet[i]=0;
        }
        for (int i = 0; i < vet.length; i++) {
            vet[i]=aux.pop();
        }    
    }

    // recebe a pilha preenchida e retorna uma pilha exatamente igual a que foi recebida por parâmetro
    // utilizar pilhas para realizar a clonagem 
    public static Pilha getClone(Pilha p) {
        Pilha aux = new Pilha();
        Pilha auxx = new Pilha();
        for (int i = 0; i < p.size(); i++) {
            aux.push(p.pop());
        }
        for (int i = 0; i < aux.size(); i++) {
            auxx.push(aux.pop());
        }
        return auxx;
    }
    
    // recebe uma pilha preenchida e uma lista vazia
    // move os elementos da pilha para a lista mantendo a ordem da pilha
    public static void addAll(Pilha p, LinkedListOfInteger l) {
        Pilha aux = new Pilha();
        for (int i = 0; i < aux.size(); i++) {
            aux.push(p.pop());
            l.add(aux.pop());
        }        
    }
}
