import java.io.*;
import java.util.*;

public class Main {
    static int clock(int d, int pos, int n, int m){
        if(d == 1){
            return pos;
        } else if(d == 2){
            return n + m + (n - pos);
        } else if(d == 3){
            return 2 * n + m + (m - pos);
        } return n + pos;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(in.readLine());
        int total = 2 * n + 2 * m;
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            l.add(clock(d, pos, n, m));
        }

        st = new StringTokenizer(in.readLine());
        int sd = Integer.parseInt(st.nextToken());
        int sp = Integer.parseInt(st.nextToken());
        int sLen = clock(sd, sp, n, m);
        int ret = 0;
        for(int len : l){
            int sum1 = Math.abs(sLen - len);
            ret += Math.min(sum1, total - sum1);
        }
        out.println(ret);


        out.flush();
        out.close();
    }
}