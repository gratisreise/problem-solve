import java.util.*;

public class Main {
    static int n, k, temp, ret = Integer.MIN_VALUE;
    static int[] psum = new int[100005];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            temp = sc.nextInt();
            psum[i] = psum[i - 1] + temp;
        }

        for (int i = k; i <= n; i++) {
            ret = Math.max(ret, psum[i] - psum[i - k]);
        }

        System.out.println(ret);
    }
    
}
