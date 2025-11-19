import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int[] psum = new int[n+1];

        for(int i = 1;  i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            psum[i] = psum[i-1] + num;
        }
        int mx = Integer.MIN_VALUE;
        for(int i = k; i <= n; i++){
            mx = Math.max(mx, psum[i] - psum[i-k]);
        }
        System.out.println(mx);


        out.flush();
        out.close();
    }
}