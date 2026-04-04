import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static long count(long mid){
        long cnt = m;
        for(int t : arr){
            cnt += mid / t;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < m; i++) arr[i] = Integer.parseInt(st.nextToken());
        if(n <= m) {
            System.out.println(n);
            return;
        }

        long l = 0, r = 2_000_000_000L * 30L;
        long time = 0;
        while(l <= r){
            long mid = (l + r) / 2;
            long count = count(mid);
            if(count >= n){
                r = mid - 1;
                time = mid;
            } else l = mid + 1;
        }

        long prevCount = count(time - 1);

        for(int i = 0; i < m; i++){
            if(time % arr[i] == 0) {
                prevCount++;
                if(prevCount == n){
                    out.println(i + 1);
                    break;
                }
            }
        }

        out.flush();
        out.close();
    }
}