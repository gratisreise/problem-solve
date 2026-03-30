import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int idx = 1;
        Deque<Integer> stk = new ArrayDeque<>();
        List<String> ret = new ArrayList<>();
        String plus = "+";
        String minus = "-";
        for(int i = 0; i < n; i++){
            int now = Integer.parseInt(in.readLine());
            while(idx <= now){
                stk.push(idx++);
                ret.add(plus);
            }
            if(!stk.isEmpty() && stk.peek() != now){
                System.out.println("NO");
                return;
            }
            if(!stk.isEmpty() && stk.peek() == now){
                stk.pop();
                ret.add(minus);
            }
        }
        for(String s : ret) out.println(s);



        out.flush();
        out.close();
    }
}