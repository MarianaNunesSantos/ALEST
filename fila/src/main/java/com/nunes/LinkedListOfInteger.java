 package com.nunes;

public class LinkedListOfInteger {
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            this.next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int cont;

     /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        cont = 0;
    }
        
        //retorna true se a lista nao contem elementos
        //verificação se a lista está vazia
        public boolean isEmpty(){  // O(1)
            return (head==null);
        }

        //retorna quantos elementos tem na lista
        public int size(){ //O(1)
            return cont;
        }

        //esvazia a lista tirando a referencia da lista
        public void clear(){ // O(1)
            head=null;
            tail=null;
            cont=0;
        }

        //adiciona um elemento ao final da lista
        //passado por parametro o elemento a ser adicionado
        public void add (Integer element){ // O(1)
            //criar o nodo
            Node n = new Node(element);
            //conectar o nodo na lista
            //verificar se a lista esta vazia
            //  atualizar o head 
            //  caso contrario, conectar o novo nodo no tail
            if (head==null) {
                head =n;
            }else{
                tail.next = n;
            }
            tail=n;
            //atualizar o tail
            //atulizar o count
            cont++;
        }

        //criação do método contains
        //Criar uma varial referencia do tipo Node
        //uma estrutura de repetição para quando não chega ao final da estrutura
        //      verificar se o elemento esta no nodo corretamente
        //          retorna true
        //      avança para o proximo nodo
        //retorna falso se não encontra
        public boolean contains (Integer element){
            Node aux = head; //nao esta criando nodo, esta usando refencia para percorrer a lista 
            while (aux != null) {
                if (aux.element.equals(element)) {
                    return true; //elemento existe
                }
                aux = aux.next; //avançar o "ponteiro" para o proximo nodo
            }
            return false; //elemento n existe
        }

        //get: retorna o elemento armazenado em um index na lista
        //index == posição logica na lista, começa no zero (0-1-2-3-...)
        //verificar se o index é valido ou inválido
        //inválido == ERRO
        //verificar se o index corresponde a posição logica do tail
        //  return o elemento armazenado no tail
        //uma estrutura de repetição pra percorre a lista ate o index correspondente
        //      define variavel aux tipo node
        //      variavel cont posições
        //      enquanto contador < index 
        //          avança
        //      retorna o elemento quando chega no index
        public Integer get (int index){
            if (index < 0 || index >= cont) {
                throw new IndexOutOfBoundsException("ERRO: "+index);
            }
            if (index == cont-1) { // posiçao logica do tail
                return tail.element; //retorna o elemeto do tail
            }
            Node aux = head;
            int cont=0;
            while (cont < index) {
                aux = aux.next;
                cont++;
            }
            return aux.element; // retorna o elemento na posição do index
        }

        //indexOf: retorna o index que se encontra o elemento e recebe por parametro o elemento
        //criar a variavel aux do tipo nodo
        //percorrer a lista ate o final, aonde a varialvel aux != null
        //verificar se o elemento esta no nodo atual
        //avançar para o proximo
        //n encontrado retorna -1
        public int indexOf (Integer element){
            Node aux = head;
            int cont=0;
            while (aux != null) {
                if (aux.element.equals(element)){
                    return cont;
                }
                aux = aux.next;
                cont++;
            }
            return -1;
        }

        public void add (int index, Integer element){
            if (index<0 || index > cont) {
                throw new IndexOutOfBoundsException("Erro!! "+index);//verifica index se é valido
            }
            Node n = new Node (element);
            if (index == 0) {//insere no inicio
                if (head == null) { // verifica se lista esá vazia
                    tail=n;
                }else{
                    n.next = head;
                }
                head=n;
            }else{
                if (index==cont) {//add no final da lista
                    tail.next=n;
                    tail=n;
                }else{//insere no meio da lista
                    Node aux = head;
                    for (int i = 0; i < index-1; i++) {//acha a posição na lista
                        aux = aux.next;
                    }
                    n.next=aux.next;
                }
            }
            cont ++;
        }

        public boolean remove (Integer element){
            if (cont == 0) {
                return false;
            }
            if (head.element.equals(element)) {//remove inicio
                if (cont == 1) {//tem só um nodo
                    tail = null;
                }
                head = head.next;
                cont--;
                return true;
            }
            Node ant = head;
            Node aux = head.next;
            for (int i = 1; i < cont; i++) {//remoçao no meio e no final da lista
                if (aux.element.equals(element)) {
                    if (aux == tail) {//remoçao no final da lista
                        tail = ant;
                        tail.next = null;
                    }else{
                        ant.next = aux.next;
                    }
                    cont--;
                    return true;
                }
                ant = ant.next;
                aux = aux.next;
            }
            return false;
        }

     /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {  // O(n)
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        
        // Se remocao do primeiro
        if (index == 0) {
            Integer elemRemovido = head.element;
            head = head.next;
            if (cont == 1) {// se tinha apenas um elemento na lista
                tail = null;
            }
            cont--;
            return elemRemovido;
        }

        Node ant = head;
        for (int i = 0; i < index - 1; i++) {
            ant = ant.next;
        }
        Integer elemRemovido = ant.next.element;
        if (index == cont - 1) { //se remocao do ultimo
            tail = ant;
            tail.next = null;
        } else { // se remocao do meio
            ant.next = ant.next.next;
            // Alternativa para o comando acima
            // Node aux = ant.next;
            // ant.next = aux.next;
        }
        cont--;
        return elemRemovido;
    }


        //mostra todos os elementos da lista
        @Override
        public String toString() { // O(n)
            StringBuilder s = new StringBuilder();
            Node aux = head;
            while (aux != null) {
                s.append(aux.element.toString());
                s.append("\n");
                aux = aux.next;
            }
            return s.toString();
        } 


    }

