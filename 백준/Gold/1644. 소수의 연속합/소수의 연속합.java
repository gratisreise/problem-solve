import java.io.*;
import java.util.*;

public class Main{
    static int n, p, s, e, ret, sum;
    static int[] a;
    static boolean[] che;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        che = new boolean[n + 4];
        a = new int[n / 2 + 4];
        for(int i = 2; i <= n; i++){
            if(che[i]) continue;
            for(int j = 2 * i; j <= n; j += i){
                che[j] = true;
            }
        }

        for(int i = 2; i <= n; i++){
            if(!che[i]) a[p++] = i;
        }

        while(true){
            if(sum >= n) sum -= a[s++];
            else if(e == p) break;
            else sum += a[e++];
            if(sum == n) ret++;
        }

        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}