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
        List<Integer> l = new ArrayList<>();
        for(int i = n-1; i >= 0; i--){
            l.add(arr[i], i+1);
        }
        for(int i : l) out.print(i+" ");

        out.flush();
        out.close();
    }
}