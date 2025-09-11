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
