import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int ret = 0;
        for(int i = 0; i < n; i++){
            var stack =  new ArrayDeque<Character>();
            String s = in.readLine();
            for(char c : s.toCharArray()){
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                } else stack.push(c);
            }
            if(stack.isEmpty()) ret++;
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}
/*
같은글자끼리쌍짓기, 선교차 x,
쌓이면서 같은 글자는 펑 => 남는거 없으면 끝
*/