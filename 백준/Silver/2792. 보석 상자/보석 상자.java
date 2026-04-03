import java.io.*;
import java.util.*;

public class Main {

    static int[] stones;
    static int n, m;
    static boolean check(long mid){
        int cnt = 0;
        for(int i = 0; i < m; i++){
            cnt += stones[i]/ mid;
            if(stones[i] % mid > 0) cnt++;
        }
        return cnt <= n;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        stones = new int[m];
        long r = -1;
        for(int i = 0; i < m; i++) {
            stones[i] = Integer.parseInt(in.readLine());
            r = Math.max(r, stones[i]);
        }
        long l = 1;

        long ret = -1;
        while(l <= r){
            long mid = (l + r) / 2;
            if(check(mid)){
                r = mid - 1;
                ret = mid;
            } else {
                l = mid + 1;
            }
        }

        out.println(ret);
        out.flush();
        out.close();
    }
}