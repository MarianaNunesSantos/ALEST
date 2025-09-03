public class Trabalho1 {
    public static void main(String[] args) {
        int op=0;
        System.out.println("N    |#OP");
        for (int n = 0; n <= 1000; n+=100) {
            //op = f1(n);
            //op = f2(n);
            //op = f3(n);
            //op = f4(n);
            //op = f5(n);
            // chamada dos demais métodos
            System.out.println(n + "    |" + op);
        }
    }


    public static int f1 (int n){
        int i,j,k,res=0;
        int cont=0;
        for (i = n; i < n+1; i+=1) {
            for ( j = n+1; j < n+i; j+=i) {
                for (k = 1; k <= i*i; k+=i/2+1) {
                    res = res + k + 1;
                    cont++;
                }
            }
        }
        return cont;
    }//fim f1

    public static int f2 (int n){
        int i, j,k, res=0;
        int cont=0;
        for (i=n; i<=n+1; i+=2) {
            for(j=n+1; j<=n*n; j+=2){
                for (k=i+1; k<=2*n; k+=2) {
                    res = res +n;
                    cont++;
                }
            }
        }
        return cont;
    }//fim f2

    public static int f3 (int n){
        int i, j,k, res=0;
        int cont=0;
        for(i=n+1; i<=n+1; i+=1){
            for (j=n; j<=i+1; j+=j/2+1) {
                for (k=j; k<=n*j; k+=Math.abs(j-i)+1) {
                    res = res + Math.abs(j-i);
                    cont++;
                }
            }
        }
        return cont;
    }//fim f3

    public static int f4 (int n){
        int i, j,k, res=0;
        int cont=0;
        for (i = n / 2; i <= n * n; i += 1) {
            for (j = 1; j <= n * n; j += i / 2 + 1) {
                for (k = 2; k <= i * j; k += j / 2 + 1) {
                    res = res+ j + 1;
                    cont++;
                }
            }
        }
        return cont;
    }//fim f4

    public static int f5 (int n){
        int i, j,k, res=0;
        int cont=0;
        for (i = n / 2; i <= n + 1; i += 2) {
            for (j = i; j <= n * i ; j += i / 2 + 1) {
                for (k = i + 1; k <=n * j; k += 1) {
                    res = res + n + j;
                    cont++;
                }
            }
        }
    return cont;
    }//fim f5


}
