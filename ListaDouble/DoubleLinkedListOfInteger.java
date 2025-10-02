

public class DoubleLinkedListOfInteger {
    private class Node{
        public Integer element;
        public Node next;
        public Node prev;
        private int cont;

        public Node(Integer element){
            this.element=null;
            this.next=null;
            this.prev=null;            
        }
    }
    private Node header;
    private Node trailer;
    private int cont;

    public DoubleLinkedListOfInteger(){
        Node header = new Node(null);
        Node trailer = new Node(null);
        header.next=trailer;
        trailer.prev=header;
        cont=0;

    }
        
    public boolean isEmpty(){
        return (header.next==trailer);
        //return (cont == 0); funciona tambem
    }

    public int size(){
        return cont;
    }

    public void clear(){
        header = new Node(null);
        trailer = new Node (null);
        header.next=trailer;
        trailer.prev=header;
        cont=0;
    }

    public boolean contains (Integer element){
        Node aux = header.next;
        for (int i = 0; i < cont; i++) {
            if (aux.element.equals(element)){
                return true;
            }
            aux=aux.next;
        }          
        return false;        
    }

    public int indexOf(Integer element){
        Node aux = header;
        for (int i = 0; i < cont; i++) {
            if (aux.element.equals(element)){
                return i;
            }
            aux=aux.next;
        }          
        return -1;
    }

    //1-criar nodo n
    //2-conectar o nodo na lista
    /*
     *  ->conectar n
     *  ->conectar o prev e o next na conexao
     * 
     * 
     *  
     * 
     * header.next=n;
     * n.next=trailer;
     * n.prev=header;
     * trailer.prev=n;
     * 
     * ERRADO
     * 
     */
    public void add(Integer element){
        Node n = new Node(element);
        n.prev = trailer.prev;
        n.next = trailer;
        trailer.prev.next = n;
        trailer.prev = n;
    }
 
    //remover nodo
    //da esquerda para a direita estou navegando e na direita estou atribuindo valores
    //aux.prev.next = aux.next
    //aux.next.prev = aux.prev
    public boolean remove(Integer element){
        Node aux = header.next;//header agr é um sentinela
        for(int i =0; i<cont; i++){
            if (aux.element.equals(element)){
                aux.prev.next=aux.next;
                aux.next.prev=aux.prev;
                cont--;
                return true;    
            }
            aux=aux.next;
        }
        return false;   
    }

    private Node getNodeIndex(int index){
        Node aux = null;//n inicializar com o header pq ainda n sabemos a posição do node a ser buscado
        if (index <= cont/2){//vendo onde é o meio da lista para ver ainde comçamos a buscar, header ou trailer
            aux=header.next;//fazendo o percurso do inicio para o fim depois da verificação do if
            for (int i = 0; i < index; i++) {
                aux= aux.next;
            }
        }else{
            aux=trailer.prev;
            for (int i = cont-1; i > index; i--) {
                aux=aux.prev;
            }
        }
        return aux;
    }

    public void add (int index, Integer element){
        if(index < 0 || index > cont){
            throw new IndexOutOfBoundsException("Erro, index inválido!");
        }else if(index == cont){
            add(element);
        }else{
            Node n = new Node(element);
            Node aux = getNodeIndex(index);
            n.next = aux.prev;
            n.prev = aux.prev.next;
            aux.prev.next = n.prev;//acho q esta muito errado esse e o de baixo
            aux.prev = n.next; 
        }
        cont++;
    }

    public Integer get (int index){
        if(index < 0 || index >= cont){
            throw new IndexOutOfBoundsException("Erro, index inválido!");
        }else{
            Node aux = getNodeIndex(index);
            Integer element = aux.element;
            return element;
        }
    }

    public Integer set(int index, Integer novo){
        if(index < 0 || index >= cont){
            throw new IndexOutOfBoundsException("Erro, index inválido!");
        }else{
            Node aux = getNodeIndex(index);
            Integer auxE = aux.element;
            aux.element = novo;
            return auxE;
        }
    }

    public Integer removeByIndex(int index){
        if (index < 0 || index >= cont){
            throw new IndexOutOfBoundsException("Erro, index inválido!");
        }else{
            Node aux = getNodeIndex(index);
                aux.prev.next=aux.next;
                aux.next.prev=aux.prev;
                cont--;
            Node auxn = getNodeIndex(index);
            Integer auxE = auxn.element;
            return auxE; 
        }
    }


    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        while(aux.next != null){
            s.append(aux.element.toString());
            s.append("\n");
            aux=aux.next;
        }
        return s.toString();
    }

    public String toStringBackToFront(){
        StringBuilder s = new StringBuilder();
        Node aux = trailer.prev;
        while(aux.prev != null){
            s.append(aux.element.toString());
            s.append("\n");
            aux=aux.prev;
        }
        return s.toString();    
    }




}//fim linkedlist
