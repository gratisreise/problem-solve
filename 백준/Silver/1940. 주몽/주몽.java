import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        var st = new StringTokenizer(in.readLine());
        int[] arr = new int[n + 1];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int limit = 200_000;
        if(m > limit){
            System.out.println(0);
            return;
        }
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == m){
                    ret++;
                }
            }
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}