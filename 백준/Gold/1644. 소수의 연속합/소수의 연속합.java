import java.util.*;

public class Main {
    static int n, p, lo, hi, ret, sum;
    static int[] a;
    static boolean[] che;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        che = new boolean[n + 2];
        a = new int[n/2 + 4];
        for(int i = 2; i <= n; i++){
            if(che[i]) continue;
            for(int j = 2 * i; j <= n; j += i){
                che[j] = true;
            }
        }
        //p는 0이니깐 ++해주며 인덱스 이동
        for(int i = 2; i <= n; i++){
            if(!che[i]) a[p++] = i;
        }
        //lo는 0 hi는 0
        while(true){
            if(sum >= n) sum -= a[lo++];
            else if(hi == p) break;
            else sum += a[hi++];
            if(sum == n) ret++;
        }

        System.out.println(ret);
    }
}