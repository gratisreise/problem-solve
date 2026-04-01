import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> mp1 = new HashMap<>(); // 빈도
        Map<Integer, Integer> mp2 = new HashMap<>(); // 등장
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            int now = Integer.parseInt(st.nextToken());
            mp1.put(now, mp1.getOrDefault(now, 0) + 1);
            if(!mp2.containsKey(now)) mp2.put(now, i);
        }
        var nums = new ArrayList<>(mp1.keySet());
        nums.sort((a, b) -> {
            if(mp1.get(a) == mp1.get(b)) return mp2.get(a) - mp2.get(b);
            return mp1.get(b) - mp1.get(a);
        });
        for(int num : nums){
            for(int i = 0; i < mp1.get(num); i++){
                out.print(num + " ");
            }
        }


        out.flush();
        out.close();
    }
}