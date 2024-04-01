import java.util.*;

public class Main {
    static int n, m;
    static int[][] a = new int[104][104];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i  < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                char c = s.charAt(j);
                if(c == 'c') a[i][j] = 0;
                else a[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0){
                    int cnt = 1;
                    while(a[i][j + 1] == -1){
                        a[i][j+1] = cnt++;
                        j++;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}