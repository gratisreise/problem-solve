import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<Integer> l = new ArrayList<>();
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < s; i++) l.add(Integer.parseInt(st.nextToken()));
        l.sort((a,b ) -> a-b);
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < r; i++) set.add(Integer.parseInt(st.nextToken()));
        
        
        Set<Integer> removed = new HashSet<>();
        for(int i = 0; i < s; i++){
            int now = l.get(i);
            if(set.contains(now)) {
                set.remove(now);
                removed.add(now);
            }
        }
        int ret = 0;
        for(int i = 0; i < s; i++){
            int now = l.get(i);
            if(removed.contains(now)) continue;
            if(set.contains(now - 1)) set.remove(now - 1);
            else if(set.contains(now + 1)) set.remove(now + 1);
            else ret++;
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}