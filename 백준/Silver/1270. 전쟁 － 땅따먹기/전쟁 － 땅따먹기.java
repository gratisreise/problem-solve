import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());

            int t = Integer.parseInt(st.nextToken());
            Map<Long, Integer> mp = new HashMap<>();

            for(int j = 0; j < t; j++){
                long num = Long.parseLong(st.nextToken());
                if(!mp.containsKey(num)) mp.put(num, 0);
                mp.put(num, mp.get(num)+1);
            }
            boolean flag = false;
            for(long key : mp.keySet()){
                int now = mp.get(key);
                if(now > t / 2) {
                    out.println(key);
                    flag = true;
                }
            }
            if(!flag) out.println("SYJKGW");
        }

        out.flush();
        out.close();
    }
}