import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[15004];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        int ret = 0;
        if(m > 200000) System.out.println(ret);
        else{
            for(int i = 0; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(a[i] + a[j] == m) ret++;
                }
            }
            System.out.println(ret);
        }
    }
}