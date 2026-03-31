import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        char[] str = in.readLine().toCharArray();
        String s = in.readLine();
        int len = s.length();
        char last = s.charAt(len-1);
        var stk = new ArrayDeque<Character>();
        for(char c : str){
            stk.addLast(c);
            if(stk.size() >= len && stk.peekLast() == last){
                var temp = new StringBuilder();
                for(int i = 0; i < len; i++) temp.append(stk.pollLast());
                if(temp.reverse().toString().equals(s)) continue;
                for(int i = 0; i < len ; i++) stk.addLast(temp.charAt(i));
            }
        }
        if(stk.isEmpty()){
            out.println("FRULA");
        } else {
            var ret = new StringBuilder();
            while(!stk.isEmpty()) ret.append(stk.pollFirst());
            out.println(ret);
        }


        out.flush();
        out.close();
    }
}