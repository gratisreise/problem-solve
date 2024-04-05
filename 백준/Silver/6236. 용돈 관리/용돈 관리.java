import java.util.*;

public class Main {
    static long n, m;
    static int lo, hi, mid, ret;
    static int[] a = new int[100004];
    static boolean check(int mid){
        int cnt = 1, temp = mid;
        for(int i = 0; i < n; i++){
            if(temp < a[i]){
                temp = mid;
                cnt++;
            }
            temp -= a[i];
        }
        return cnt <= m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        m = sc.nextLong();

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            lo = Math.max(lo, a[i]);
        }
        hi = 1_000_000_004;
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(check(mid)){
                hi = mid - 1;
                ret = mid;
            } else lo = mid + 1;
        }
        System.out.println(ret);
    }
}