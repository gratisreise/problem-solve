import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);


        int n = Integer.parseInt(in.readLine());
        List<String> l = new ArrayList<>();

        for(int i = 0; i < n; i++){
            l.add(in.readLine());
        }

        int m = l.get(0).length();
        int ret = m-1;
        for(int i = 1; i <= m; i++){
            int idx =  m - i;
            Set<String> st = new HashSet<>();
            for(String s : l){
                st.add(s.substring(idx));
            }
            if(st.size() == n){
                ret = i;
                break;
            }
        }
        System.out.println(ret);


        out.flush();
        out.close();
    }
}