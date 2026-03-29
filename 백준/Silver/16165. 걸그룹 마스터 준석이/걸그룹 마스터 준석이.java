import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken()); // 걸그룹 수
        int m = Integer.parseInt(st.nextToken()); // 문제 수
        Map<String, List<String>> mp1 = new HashMap<>(); // 팀이름 -> 멤버전원
        Map<String, String> mp2 = new HashMap<>(); // 멤버이름 -> 팀이름
        for(int i = 0; i < n; i++){
            String team = in.readLine();
            int k = Integer.parseInt(in.readLine());
            mp1.put(team, new ArrayList<>());
            for(int j = 0; j < k; j++){
                String name = in.readLine();
                mp2.put(name, team);
                mp1.get(team).add(name);
            }
        }

        for(var entry : mp1.entrySet()){
            entry.getValue().sort(String::compareTo);
        }

        for(int i = 0; i < m; i++){
            String str = in.readLine();
            int cmd = Integer.parseInt(in.readLine());
            if(cmd == 1) out.println(mp2.get(str));
            else {
                for(String s : mp1.get(str)){
                    out.println(s);
                }
            }
        }

        out.flush();
        out.close();
    }
}