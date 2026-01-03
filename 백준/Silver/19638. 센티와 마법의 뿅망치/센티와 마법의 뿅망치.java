import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i=  0; i < n; i++){
            int now = Integer.parseInt(in.readLine());
            pq.add(now);
        }

        int cnt = 0;

        while(cnt < t && pq.peek() >= h){
            cnt++;
            if(pq.peek() == 1) continue;
            pq.add(pq.poll()/2);
        }

        if(pq.peek() >= h){
            out.println("NO");
            out.println(pq.peek());
        } else {
            out.println("YES");
            out.println(cnt);
        }


        out.flush();
        out.close();
    }
}