import com.sun.security.jgss.GSSUtil;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();

        List<String> l = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for(char c : s.toCharArray()){
            if(prev != c) {
                l.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(c);
            prev = c;
        }
        if(!sb.isEmpty()) l.add(sb.toString());

        StringBuilder ret = new StringBuilder();
        for(String ss : l){
            if(ss.charAt(0) == 'X') {
                if(ss.length() % 2 == 1){
                    System.out.println(-1);
                    return;
                }
                int len = ss.length();
                int cnt4 = len / 4;
                len %= 4;
                int cnt2 = len / 2;
                var ssb = new StringBuilder();
                for(int i = 0; i < cnt4; i++){
                    ssb.append("AAAA");
                }
                for(int i = 0; i < cnt2; i++){
                    ssb.append("BB");
                }
                ret.append(ssb);
            } else ret.append(ss);
        }
        System.out.println(ret);
//        System.out.println(l);

        out.flush();
        out.close();
    }
}