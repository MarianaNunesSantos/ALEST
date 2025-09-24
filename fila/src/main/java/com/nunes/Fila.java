package com.nunes;
import com.nunes.LinkedListOfInteger;

public class Fila {

    private LinkedListOfInteger fila;

    public Fila () {
        fila = new LinkedListOfInteger();
    }

    // Insere no fim da fila
    public void enqueue(Integer e) {
       // insira aqui o código que insere na fila (fim)
       fila.add(e); 
    }

    // Remove e retorna o elemento do inicio da fila
    public Integer dequeue() {
        // Primeiro verifica se a fila nao esta vazia
        if (fila.isEmpty())
            throw new EmptyQueueException("A fila esta vazia!");
        
        // insira aqui o código que remove da fila (inicio)
        return fila.removeByIndex(0);
    }

    public Integer head () {
        // Primeiro verifica se a fila nao esta vazia
        if (fila.isEmpty())
            throw new EmptyQueueException("A fila esta vazia!");
        
        // insira aqui o código que retorna o elemento que está no início da fila
        return fila.get(0);
    }

    //quantidade elementos dentro da fila
    public int size() {
        return fila.size();
    }

    //verifica se a fila esta vazia
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    //limpa a fila
    public void clear() {
        fila.clear();
    }
}
