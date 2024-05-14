import java.util.*;

public class Main {
    static long t, n;
    static long[] dp = new long[10001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        dp[0] = 1;
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 10000; j++){
                if(j - i >= 0) dp[j] += dp[j - i];
            }
        }
        while(t-- > 0){
            n = sc.nextInt();
            System.out.println(dp[(int)n]);
        }
    }
}