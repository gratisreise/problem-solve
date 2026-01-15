import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        var pq = new PriorityQueue<Stack<Integer>>((a, b) -> a.peek() - b.peek());

        for(int i = 0; i < m; i++){
            int k = Integer.parseInt(in.readLine());
            var tempStk = new Stack<Integer>();
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < k; j++){
                int num = Integer.parseInt(st.nextToken());
                tempStk.push(num);
            }
            pq.add(tempStk);
        }
        
        var stk = new Stack<Integer>();
        while(!pq.isEmpty()){
            var now = pq.poll();
            if(stk.isEmpty()){
                stk.push(now.pop());
            } else {
                if(stk.peek() + 1 == now.peek()) stk.push(now.pop());
                else {
                    System.out.println("No");
                    return;
                }
            }
            if(!now.isEmpty()) pq.offer(now);
        }
        out.println("Yes");

        out.flush();
        out.close();
    }
}