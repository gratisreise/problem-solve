import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> mp1 = new HashMap<>(); //번호 -> 이름
        Map<String, Integer> mp2 = new HashMap<>(); //이름 -> 번호
        for(int i = 0; i < n; i++){
            String name = in.readLine();
            mp1.put(i+1, name);
            mp2.put(name, i+1);
        }

        for(int i = 0; i < m; i++){
            String input = in.readLine();
            if(Character.isUpperCase(input.charAt(0))){
                out.println(mp2.get(input));
            } else {
                int num = Integer.parseInt(input);
                out.println(mp1.get(num));
            }
        }

        out.flush();
        out.close();
    }
}