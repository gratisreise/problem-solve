import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        var st = new StringTokenizer(in.readLine());
        int[] arr = new int[n];
        for(int i=  0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int prev = -1;
        for(int i = 0; i <n; i++){
            if(prev == arr[i]){
                out.println(arr[i]);
                break;
            }
            prev = arr[i];
        }
        

        out.flush();
        out.close();
    }
}