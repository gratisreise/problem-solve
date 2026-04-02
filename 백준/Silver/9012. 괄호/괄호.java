import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            var stk = new ArrayDeque<Character>();
            for(char c : s.toCharArray()){
                if(!stk.isEmpty() && stk.peek() == '(' && c == ')'){
                    stk.pollLast();
                } else stk.addLast(c);
            }
            if(stk.isEmpty()) out.println("YES");
            else out.println("NO");
        }


        out.flush();
        out.close();
    }
}