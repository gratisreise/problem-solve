import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> mp1 = new HashMap<>(); // 이름-> 번호
        Map<String, Integer> mp2 = new HashMap<>(); // 번호-> 이름
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            mp1.put(i+1, s);
            mp2.put(s, i+1);
        }
        for(int i = 0; i < m; i++){
            String s = in.readLine();
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9'){
                int num = Integer.parseInt(s);
                out.println(mp1.get(num));
            } else {
                out.println(mp2.get(s));
            }
        }

        out.flush();
        out.close();
    }
}