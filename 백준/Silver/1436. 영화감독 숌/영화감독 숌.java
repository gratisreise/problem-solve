import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        
        int n = Integer.parseInt(in.readLine());
        int cnt = 0;
        int i = 666;
        for(; ; i++){
            if((""+i).contains("666")) cnt++;
            if(cnt == n) break;
        }
        out.println(i);

        out.flush();
        out.close();
    }
}