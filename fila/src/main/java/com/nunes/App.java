package com.nunes;
public class App {
    public static void main(String[] args) {
        Fila f = new Fila ();
        f.enqueue(1);
        f.enqueue(2);
        f.enqueue(3);
        f.enqueue(4);

        //int tam = f.size();
        //for(int i=0; i<tam; i++) {
        //    System.out.println(f.dequeue());
        //}
        // OU
 
        while(!f.isEmpty()) {
            System.out.println(f.dequeue());
        }



    }


    // escreva um método que recebe uma fila e retorna esta fila invertida
    // para resolver este problema utilize uma pilha auxiliar
    // public static Fila inverte (Fila f){
    
}
