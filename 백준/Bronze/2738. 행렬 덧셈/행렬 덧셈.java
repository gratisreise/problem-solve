import java.util.Scanner;

public class Main {
    public static int[][] a = new int[104][104];
    public static int[][] b = new int[104][104];
    public static int[][] ret = new int[104][104];

    public static void input(int[][] arr, int n, int m, Scanner sc){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        
        input(a, n, m, sc);
        input(b, n, m, sc);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ret[i][j] = a[i][j] + b[i][j];
            }
        }
       
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
