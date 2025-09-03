public class AulaResursivo {
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("O somatórioR de 5 é: "+somatorioR(n));
        System.out.println("O somatórioI de 5 é: "+somatorioI(n));
    }
    
    public static int somatorioR (int n){
        if (n == 1) {
            return 1;
        }else{
            return n+somatorioR(n-1);
        }
    }

    public static int somatorioI (int n){
        int somaI=0;
        for (int i = 1; i <= n; i++) {
            somaI = i + somaI;       
        }
        return somaI;
    }

}
