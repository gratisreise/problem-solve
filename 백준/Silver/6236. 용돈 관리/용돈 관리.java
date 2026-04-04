import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean check(int mid){
        int cnt = 0;
        int temp = 0;
        for(int money : arr){
            if(money > mid) return false;
            if(temp - money < 0){
                temp = mid - money;
                cnt++;
            } else temp -= money;
        }
        return cnt <= m;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int l = 1, r = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            r += arr[i];
        }
        int k = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(check(mid)){ // 가능하면 줄이고
                r = mid - 1;
                k = mid;
            } else{ // 안되면 늘리고
                l = mid + 1;
            }
        }

        out.println(k);

        out.flush();
        out.close();
    }
}