import java.io.*;
import java.util.*;

public class Main {
    static long gcd(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());
        for(int i = 0; i < t; i++){
            var st = new StringTokenizer(in.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            while(a != 1){
                long x = (b + a -1) / a;
                a = a * x - b;
                b = b * x;
                long divide = gcd(a, b);
                a /= divide;
                b /= divide;
            }
            out.println(b);
        }

        out.flush();
        out.close();
    }
}