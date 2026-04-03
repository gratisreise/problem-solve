import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        var l = new ArrayList<int[]>();
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l.add(new int[]{a, b});
        }
        l.sort((a, b) -> a[0] - b[0]);
        int now = 0;
        for(int[] arr : l){
            int arrive = arr[0];
            int takes = arr[1];
            if(arrive > now) now = arrive;
            now += takes;
        }
        out.println(now);


        out.flush();
        out.close();
    }
}