import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) q.add(i);

        var ret = new StringBuilder();
        while(!q.isEmpty()){
            ret.append(q.poll()).append(" ");
            if(!q.isEmpty()) q.add(q.poll());
        }
        System.out.println(ret.toString().trim());

        out.flush();
        out.close();
    }
}