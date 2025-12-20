import java.io.*;
import java.util.*;

public class Main {
    static int count(int n, int digit){
        int[] cnt = new int[10];
        while(n > 0){
            cnt[n%10]++;
            n /= 10;
        }
        return cnt[digit];
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int digit = Integer.parseInt(st.nextToken());

        int ret = 0;
        for(int i = 1; i <= n; i++){
            ret += count(i, digit);
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}