import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st  = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < l; i++){
            String num = in.readLine();
            mp.put(num, i);
        }
        var pq = new PriorityQueue<String>((a, b) -> mp.get(a) - mp.get(b));
        pq.addAll(mp.keySet());
        int limit = Math.min(k, pq.size());
        for(int i = 0; i < limit; i++) out.println(pq.poll());
        




        out.flush();
        out.close();
    }
}