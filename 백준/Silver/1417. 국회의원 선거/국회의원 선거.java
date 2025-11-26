import java.io.*;
import java.util.*;

public class Main {
    static class Pyo{
        int n; int cnt;
        Pyo(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        PriorityQueue<Pyo> pq = new PriorityQueue<>((a, b)-> Integer.compare(b.cnt, a.cnt));
        int now = Integer.parseInt(in.readLine());
        for(int i = 2; i <= n; i++){
            int num = Integer.parseInt(in.readLine());
            pq.add(new Pyo(i, num));
        }
        int ret = 0;
        while(!pq.isEmpty()){
            Pyo pyo = pq.poll();
            int mx = pyo.cnt;
            int num = pyo.n;
            if(now > mx) break;
            ret++;
            now++;
            mx--;
            pq.add(new Pyo(num, mx));
        }
        System.out.println(ret);

        out.flush();
        out.close();
    }
}