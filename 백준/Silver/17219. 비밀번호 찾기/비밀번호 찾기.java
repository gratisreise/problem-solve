import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            String site = st.nextToken();
            String pwd = st.nextToken();
            mp.put(site, pwd);
        }

        for(int i = 0; i < m; i++) out.println(mp.get(in.readLine()));


        out.flush();
        out.close();
    }
}