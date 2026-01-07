import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        var st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for(int i = 0; i < n; i++){
            min = Math.min(arr[i], min);
            ret = Math.max(ret, arr[i] - min);
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}