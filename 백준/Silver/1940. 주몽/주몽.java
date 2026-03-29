import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        var st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        int ret = 0;
        while(l < r){
            int sum = arr[l] + arr[r];
            if(sum == m){
                ret++;
                l++; r--;
            } else if(sum < m){
                l++;
            } else r--;
        }
        out.println(ret);
        out.flush();
        out.close();
    }
}