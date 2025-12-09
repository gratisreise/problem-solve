import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, List<String>> mp1 = new HashMap<>();
        Map<String, String> mp2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            String team = in.readLine();
            int k = Integer.parseInt(in.readLine());
            List<String> l = new ArrayList<>();
            for(int j = 0; j < k; j++){
                String name = in.readLine();
                l.add(name);
                mp2.put(name, team);
            }
            l.sort(Comparator.naturalOrder());
            mp1.put(team, l);
        }
        for(int i = 0; i < m; i++){
            String s = in.readLine();
            int cmd = Integer.parseInt(in.readLine());
            if(cmd == 1){
                out.println(mp2.get(s));
            } else {
                for(String name : mp1.get(s)){
                    out.println(name);
                }
            }
        }

        out.flush();
        out.close();
    }
}