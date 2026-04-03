import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        var pq1 = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); //보석pq
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq1.add(new int[]{a, b});
        }

        var l = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            l.add(Integer.parseInt(in.readLine()));
        }
        l.sort((a, b) -> a - b);
        var pq2 = new PriorityQueue<Integer>((a, b) -> b - a); //보석 가치pq
        long ret = 0;
        for(int bag : l){
            while(!pq1.isEmpty() && pq1.peek()[0] <= bag){
                int[] temp = pq1.poll();
                pq2.add(temp[1]);
            }
            if(!pq2.isEmpty()) ret += pq2.poll();
        }
        out.println(ret);



        out.flush();
        out.close();
    }
}