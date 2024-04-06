import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] b = new int[1004];
    static int[][][] dp = new int[1004][2][34];
    static final int MIN = Integer.MIN_VALUE;

    static int go(int idx, int tree, int cnt) {
        if (cnt < 0) return MIN;
        if (idx == n) return 0;
        if (dp[idx][tree][cnt] != 0) return dp[idx][tree][cnt];
        int ret = Math.max(go(idx + 1, tree ^ 1, cnt - 1), go(idx + 1, tree, cnt)) + (tree == b[idx] - 1 ? 1 : 0);
        dp[idx][tree][cnt] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            b[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Math.max(go(0, 0, m), go(0, 1, m - 1));
        System.out.println(ans);
    }
}