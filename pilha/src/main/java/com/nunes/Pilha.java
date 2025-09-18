package com.nunes;
import java.util.EmptyStackException;


public class Pilha {

	
    // atributo 
    private LinkedListOfInteger pilha;

    // construtor 
    public Pilha() {
        pilha = new LinkedListOfInteger();
    }

    // retorna a quantidade de elementos armazenados na pilha
    public int size() {
        return pilha.size();
    }

    // retorna true se a pilha está vazia ou false se a pilha não está vazia
    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    // limpa a pilha e inicia novamente
    public void clear() {
       pilha.clear();
    }


    // Insere no topo da pilha
    public void push(Integer e) {
        pilha.add(0,e);
    }

    // Remove e retorna o elemento do topo da pilha
    public Integer pop() {
        // Primeiro verifica se a pilha nao esta vazia
        if (pilha.isEmpty()){
            throw new EmptyStackException();}
        return pilha.removeByIndex(0);
        
    }

    // retorna o elemento armazenado no topo da pilha
    public Integer top() {
        // Primeiro verifica se a pilha nao esta vazia
        if (pilha.isEmpty()){
            throw new EmptyStackException();}
        return pilha.get(0);
    }

}
