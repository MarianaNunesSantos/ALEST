
public class FilaArray {
    private Integer fila[]; 
    private int cont;
    private int primeiro; // indice para o primeiro da fila
    private int ultimo; // indice para o ultimo da fila
    
    public FilaArray() {
        fila = new Integer[10];
        cont = 0;
 	primeiro = 0;
	ultimo = 0;
    }
    
   // Insere o elemento no final da fila
    public void enqueue(Integer element) {
        // Primeiro verifica se tem espaco na fila
        if (cont == fila.length) 
            throw new FullQueueException("A fila esta cheia!");
        
         //insere element no ultimo
         // incrementa cont
         // atualiza o ultimo
        fila[ultimo] = element;
        cont++;
        ultimo = (ultimo + 1) % fila.length;

    }
     
    // remove e retorna o elemento e do início da fila, 
    // e dá erro se a fila estiver vazia
    public Integer dequeue() {
        // Primeiro verifica se a fila nao esta vazia
        if (cont == 0)
            throw new EmptyQueueException("A fila esta vazia!");

        // guarda primeiro em variável auxiliar
        // limpa espaço do primeiro
        // decrementa cont
        // atualiza o primeiro
        // retorna o element guardado na auxiliar  
        Integer aux = fila[primeiro];
        fila[primeiro] = null;
        cont--;
        primeiro = (primeiro + 1) % fila.length;
        return aux;     

    }
  
    // retorna, mas não remove, o primeiro elemento da fila, 
    // e dá erro se a fila estiver vazia
    public Integer head() {
        // Primeiro verifica se a fila nao esta vazia
        if (cont == 0)
            throw new EmptyQueueException("A fila esta vazia!");
        
        // retorna o primeiro
        return fila[primeiro];
    }

    // retorna o número de elementos da fila
    public int size() {
        return cont;
    } 
    
    // retorna true se a fila estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return (cont == 0);
    }
    
    // esvazia a fila
    public void clear(){
        fila = new Integer[10];
        cont = 0;
 	primeiro = 0;
	ultimo = 0;
    } 
      
}
