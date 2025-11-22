import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());


        int ret = 0;
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            Deque<Character> dq = new ArrayDeque<>();
            for(char c : s.toCharArray()){
                if(!dq.isEmpty() && dq.getLast() == c){
                    dq.pollLast();
                } else {
                    dq.addLast(c);
                }
            }
            if(dq.isEmpty()) ret++;
        }
        System.out.println(ret);

        out.flush();
        out.close();
    }
}