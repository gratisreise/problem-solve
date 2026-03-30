import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();
        var left = new ArrayDeque<Character>();
        var right = new ArrayDeque<Character>();
        for(char c : s.toCharArray()) left.push(c);
        int m = Integer.parseInt(in.readLine());
        for(int i = 0; i < m; i++){
            var st = new StringTokenizer(in.readLine());
            char cmd = st.nextToken().charAt(0);
            if(cmd == 'L'){
                if(!left.isEmpty()) right.push(left.pop());
            } else if(cmd == 'D'){
                if(!right.isEmpty()) left.push(right.pop());
            } else if(cmd == 'B'){
                if(!left.isEmpty()) left.pop();
            } else{
                char c = st.nextToken().charAt(0);
                left.push(c);
            }
        }

        var ll = new StringBuilder();
        while(!left.isEmpty()) ll.append(left.pop());
        var rr = new StringBuilder();
        while(!right.isEmpty()) rr.append(right.pop());
        var ret = ll.reverse().append(rr);
        out.println(ret);

        out.flush();
        out.close();
    }
}