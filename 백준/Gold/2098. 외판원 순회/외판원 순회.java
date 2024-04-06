import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000000;
    static final int MAX = 16;
    static int n;
    static int[][] dist = new int[MAX][MAX];
    static int[][] dp = new int[MAX][1 << MAX];

    public static int tsp(int here, int visited) {
        if (visited == (1 << n) - 1) {
            return dist[here][0] != 0 ? dist[here][0] : INF;
        }

        if (dp[here][visited] != 0) {
            return dp[here][visited];
        }

        int ret = INF;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) continue;
            if (dist[here][i] == 0) continue;
            ret = Math.min(ret, dist[here][i] + tsp(i, visited | (1 << i)));
        }

        dp[here][visited] = ret;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
    }
}