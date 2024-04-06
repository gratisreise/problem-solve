import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp = new long[31][31];

    static long go(int whole, int half) {
        if (whole == 0 && half == 0) return 1;
        if (dp[whole][half] != 0) return dp[whole][half];

        long ret = 0;
        if (whole > 0) ret += go(whole - 1, half + 1);
        if (half > 0) ret += go(whole, half - 1);
        dp[whole][half] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            long n = Long.parseLong(br.readLine());
            if (n == 0) break;
            System.out.println(go((int) n, 0));
        }
    }
}