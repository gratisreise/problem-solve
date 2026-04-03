import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        var l  = new ArrayList<int[]>();
        for(int i = 0;  i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            l.add(new int[]{d, c});
        }
        l.sort((a, b) -> a[0] - b[0]);

        var pq = new PriorityQueue<Integer>();
        for(int[] arr : l){
            pq.add(arr[1]);
            if(!pq.isEmpty() && pq.size() > arr[0]){
                pq.poll();
            }
        }
        int ret = 0;
        while(!pq.isEmpty()) ret += pq.poll();
        out.println(ret);


        out.flush();
        out.close();
    }
}