import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        while(n-- > 0){
            int m = Integer.parseInt(in.readLine());
            Map<String, Integer> mp = new HashMap<>();
            for(int i = 0; i < m; i++){
                String[] srr = in.readLine().split(" ");
                mp.put(srr[1], mp.getOrDefault(srr[1], 1)+1);
            }
            long ret = 1;
            for(var entry : mp.entrySet()) ret *= entry.getValue();
            out.println(ret - 1);
        }

        out.flush();
        out.close();
    }
}