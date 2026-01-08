import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) dq.addLast(i);
        List<Integer> l = new ArrayList<>();
        int d = 1;
        while(!dq.isEmpty()){
            if(dq.size() == 1) {
                l.add(dq.pollFirst());
                break;
            }
            for(int i = 0; i < k-1; i++){
                if(d == 1) dq.addLast(dq.pollFirst());
                else dq.addFirst(dq.pollLast());
            }

            if(d == 1) l.add(dq.pollFirst());
            else l.add(dq.pollLast());
            if(l.size() % m == 0) {
                d *= -1;
            }
        }
        for(int i : l) out.println(i);

        out.flush();
        out.close();
    }
}