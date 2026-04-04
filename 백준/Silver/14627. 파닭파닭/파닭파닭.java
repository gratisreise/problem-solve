import java.io.*;
import java.util.*;

public class Main {
    static int s, c;
    static int[] arr;
    static boolean check(long mid){
        int cnt = 0;
        for(int i = 0; i < s; i++){
            if(arr[i] < mid) continue;
            cnt += arr[i] / mid;
        }
        return cnt >= c;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[s];
        long l = 1, r = -1;
        long sum =0;
        for(int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            r = Math.max(r, arr[i]);
            sum += arr[i];
        }
        long mid = 0;
        long temp = 0;
        while(l <= r){
            mid = (l + r) / 2;
            if(check(mid)){
                l = mid + 1;
                temp = mid;
            } else r = mid - 1;
        }
        sum -= c * temp;
        out.println(sum);


        out.flush();
        out.close();
    }
}