import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp, w;
    static final int INF = 16_000_000;
    static int go(int now, int visit){
        if(visit  == (1 << n) - 1){
            if(w[now][0] == 0) return INF;
            return w[now][0];
        }
        if(dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;
        for(int next = 0; next < n; next++){
            if(w[now][next] != 0 && (visit & (1 << next)) == 0){
                int res = go(next, visit | (1 << next));
                dp[now][visit] = Math.min(dp[now][visit], res + w[now][next]);
            }
        }
        return dp[now][visit];
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());
        w = new int[n][n];
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        out.println(go(0, 1));


        out.flush();
        out.close();
    }
}