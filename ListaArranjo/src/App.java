import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int elementos=0;
        int tam;

        System.out.println("Insira um tamanho para a lista.");
        tam = entrada.nextInt();
        ListArraOfInteger Li = new ListArraOfInteger(tam);

        for (int i = 0; i < 4; i++) {
            System.out.println("Iforme um elemento para ser add: ");
            elementos = entrada.nextInt();
            Li.add(elementos);
        }
        System.out.println("\nTamanho da lista: "+Li.size());

        System.out.println("Lista: \n"+Li);   
        System.out.println("\nEstá vazia? "+Li.isEmpty());
        Li.clear();
        System.out.println("Lista depois do clear: \n"+Li);
        System.out.println("\nTamanho da lista: "+Li.size());

        // terminar de testa todos os metodos, falta os seis ultimos metodos!!!

    }
}
