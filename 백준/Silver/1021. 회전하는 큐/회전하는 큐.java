import java.io.*;
import java.util.*;

public class Main {
    static int count(Deque<Integer> dq, int num){
        var temp1 = new ArrayDeque<Integer>(dq);
        var temp2 = new ArrayDeque<Integer>(dq);
        int cnt1 = 0;
        int cnt2 = 0;
        while(!temp1.isEmpty() && temp1.peek() != num){
            cnt1++;
            temp1.addLast(temp1.pollFirst());
        }
        while(!temp2.isEmpty() && temp2.peek() != num){
            cnt2++;
            temp2.addFirst(temp2.pollLast());
        }
        return  Math.min(cnt1, cnt2);
    }
    static void move(Deque<Integer> dq, int num){
        while(!dq.isEmpty() && dq.peek() != num){
            dq.addLast(dq.pollFirst());
        }
        dq.pollFirst();
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        var dq = new ArrayDeque<Integer>();
        for(int i = 0; i < n; i++) dq.add(i+1);

        st = new StringTokenizer(in.readLine());
        int ret = 0;
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            ret += count(dq, num);
            move(dq, num);
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}