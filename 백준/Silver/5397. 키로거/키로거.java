import java.io.*;
import java.util.*;

public class Main {
    static String stkToString(Deque<Character> stk1, Deque<Character> stk2){
        var sb1 = new StringBuilder();
        while(!stk1.isEmpty()) sb1.append(stk1.pop());
        var sb2 = new StringBuilder();
        while(!stk2.isEmpty()) sb2.append(stk2.pop());
        return sb1.reverse().append(sb2).toString();
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++){
            var left = new ArrayDeque<Character>();
            var right  = new ArrayDeque<Character>();
            String s = in.readLine();
            for(char c : s.toCharArray()){
                if(c == '-') {
                    if(!left.isEmpty()) left.pop();
                } else if(c == '<'){
                    if(!left.isEmpty()) right.push(left.pop());
                } else if(c == '>'){
                    if(!right.isEmpty()) left.push(right.pop());
                } else {
                    left.push(c);
                }
            }
            out.println(stkToString(left, right));
        }



        out.flush();
        out.close();
    }
}