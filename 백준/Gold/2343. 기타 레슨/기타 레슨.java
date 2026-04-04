import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean check(int mid){
        int cnt = 0;
        int temp = 0;
        for(int i = 0; i < n; i++){
            if(temp + arr[i] > mid){
                cnt++; temp = arr[i];
            } else temp += arr[i];
        }
        if(temp > 0) cnt++;
        return cnt <= m;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(in.readLine());
        int l = -1, r = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            l = Math.max(arr[i], l);
            r += arr[i];
        }

        int ret = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(check(mid)){
                r = mid - 1;
                ret = mid;
            } else l = mid + 1;
        }
        out.println(ret);


        out.flush();
        out.close();
    }
}