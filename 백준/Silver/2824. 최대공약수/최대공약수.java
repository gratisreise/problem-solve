import java.io.*;
import java.util.*;

public class Main {
    static int LIMIT = 1_000_000_000;
    static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    static String converter(boolean isBig, long ret){
        if(!isBig) return "" + ret;
        String ans = "0".repeat(10)+ret;
        return ans.substring(ans.length() - 9);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        long[] arr1 = new long[n];
        var st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        long[] arr2 = new long[m];
        for(int i = 0; i < m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        long ret = 1;
        boolean isBig = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                long now = gcd(arr1[i], arr2[j]);
                ret *= now;
                arr1[i] /= now;
                arr2[j] /= now;
                if(ret >= LIMIT) {
                    ret %= LIMIT;
                    isBig = true;
                }
            }
        }
        System.out.println(converter(isBig, ret));

        out.flush();
        out.close();
    }
}