import java.io.*;
import java.util.*;

public class Main {
    static boolean isIn(char c){
        return c == '[' || c == ']' || c == '(' || c == ')';
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        while(true){
            String s = in.readLine();
            if(s.equals(".")) break;
            var stk = new ArrayDeque<Character>();
            for(char c : s.toCharArray()){
                if(!isIn(c)) continue;
                if(c == '[' || c == ']'){
                    if(!stk.isEmpty() && stk.peekLast() == '[' && c == ']'){
                        stk.pollLast();
                    } else stk.addLast(c);
                } else if(c == '(' || c == ')'){
                    if(!stk.isEmpty() && stk.peekLast() == '(' && c == ')'){
                        stk.pollLast();
                    } else stk.addLast(c);
                }
            }
            if(stk.isEmpty()) out.println("yes");
            else out.println("no");
        }


        out.flush();
        out.close();
    }
}