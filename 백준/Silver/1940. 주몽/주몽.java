import java.util.*;

public class Main{
    static int[] a = new int[100004];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        if(m > 200000){
            System.out.println(0);
            return;
        }

        int ret = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] + a[j] == m){
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
}