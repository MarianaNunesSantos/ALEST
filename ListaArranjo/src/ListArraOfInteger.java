public class ListArraOfInteger {

    private static final int INITIAL_SIZE = 10;
    private Integer [] data;
    private int count;

        //cria uma lista, recebe um valor para o tamanha, se n for valido o valor, cria uma lista com uma tamanho
        //ja pre determminado
    public ListArraOfInteger (int tam){
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }//BIG O =

    public ListArraOfInteger(){
        this(INITIAL_SIZE);
    }//BIG O =

        //cria um novo objeto do tipo data criando uma nova lista
    public void clear(){
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }//BIG O =

        //metodo para saber se a lista esta vazia comparando com o count 
    public boolean isEmpty(){
        return (count == 0);
    }//BIG O =

        //retorna um nuero inteiro que corresponde a quantidade de eleentos armazenados ali dentro
    public int size(){
        return count;
    }//BIG O =

        //garante que tem espaço e guarda elemento dentro da lista, se n tem espaço ele dulica o tamanha da lista
    public void add(Integer element){
        if (count == data.length) {
            setCapacity(data.length*2);
        }
        data[count] = element;
        count++;
    }//BIG O =

        //entra um index e retorna o valor que esta nesta posição, verifica se a posição existe que o usuario mandou
    public Integer get(int index){
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("ERRO"+index);
        }
        return data[index];
    }//BIG O =

        // recebe uma nova capacidade pra lista, verifica se a nova apacidade tem tamanho diferente, cria um novo vetor, verifica
        // se o vetor antigo do vetor cabe no novo e copia do antigo para o novo, depois mata o vetor antigo
    private void setCapacity(int newCapacity) {
            if (newCapacity != data.length) {
                int min = 0;
                Integer[] newData = new Integer[newCapacity];
                if (data.length < newCapacity) {
                    min = data.length;
                } else {
                    min = newCapacity;
                }
                for (int i = 0; i < min; i++) {
                    newData[i] = data[i];
                }
                data = newData;
            }
        }

        //remove o o elemneto na primeira posição que ver
        //@param element o elemento a ser removido
        //return true se a lista contem o elemento
    public boolean remove(Integer element) { // O(n)
        // Percorre a lista procurando por element
        for (int i=0; i<count; i++) {
            if (element.equals(data[i])) { // Se achou element
                // Faz a remocao
                for(int j=i; j<count-1; j++) {
                    data[j] = data[j+1];
                }
                data[count-1] = null; // opcional
                // Atualiza o count
                count--;
                // Retorna verdadeiro
                return true;
            }
        }
        return false; // Se não encontrou, retorna falso
    }
    
        //susbstitui o elemento armazenado em uma determinada posição pelo elemento 
        //passado por parametro, retorna o elemento que foi substituido
        /*
         * @param index a posicao da lista
         * @param element o elemento a ser armazenado na lista
         * @return o elemento armazenado anteriormente na posicao da lista
         * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
         */
    public Integer set(int index, Integer element) { // O(1)
       if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("ERRO = " + index);
        }
       Integer aux = data[index]; // guarda o elemento da posicao index
       data[index] = element; // coloca o novo elemento na posicao index
       return aux; // retorna o elemento que foi susbtituido
    }    


    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Integer element) { // O(n)
        for(int i=0; i<count; i++) {
            if (data[i].equals(element))
                return true;
        }
        return false; 
    }

    /**
     * Insere um elemento em uma determinada posicao da lista
     *
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) { // O(n)
         // Primeiro verifica se index eh valido
         if ( (index<0) || (index>count) )
            throw new IndexOutOfBoundsException(); 
         
         // Verifica se tem espaco
        if (count == data.length) { 
            setCapacity(data.length * 2);
        }    
        
        // Insere o elemento em data
        for(int i=count; i>index; i--) { // "Empurra" os elementos para o lado para "abrir espaco"
            data[i] = data[i-1];
        }
        data[index] = element;         
        
        // Atualiza count
        count++; 
    }    

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     *
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) { // O(n)
        // Procura elemento no array, se achar retorna o índice
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        // Neste ponto, não achou: retorna -1
        return -1;
    }    

    
    /**
     * Remove o elemento de uma determinada posicao da lista
     *
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) { // O(n)
             // Primeiro verifica se index eh valido
         if ( (index<0) || (index>=count) )
            throw new IndexOutOfBoundsException(); 
         
         // Guarda o elemento que sera removido
         Integer elemRemovido = data[index];
         
         // Remover o elemento
         for(int i=index; i<count-1 ;i++) {
             data[i] = data[i+1];
         }
         data[count-1] = null; // opcional
         
         // Atualizar o count
         count--;
         
         // Retorna o elemento removido
        return elemRemovido;
    }    


    @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < count; i++) {
                s.append(data[i]);
                if (i != (count - 1)) {
                    s.append(",");
                }
            }
            s.append("\n");
            return s.toString();
        }
}