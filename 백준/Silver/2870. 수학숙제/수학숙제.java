import java.io.*;
import java.util.*;

public class Main {
    static boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
    static String cut(String s){
        int idx = 0;
        while(idx < s.length() && s.charAt(idx) == '0'){
            idx++;
        }
        return idx == s.length() ? "0" : s.substring(idx);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        List<String> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            int len = s.length();
            for(int j = 0; j < len; j++) {
                int temp = j;
                var sb = new StringBuilder();
                while (temp < len && isNumber(s.charAt(temp))) {
                    sb.append(s.charAt(temp++));
                }
                j = temp;
                if(sb.length() > 0) l.add(sb.toString());
            }
        }
        var ret = new ArrayList<String>();
        for(String s : l){
            if(s.charAt(0) == '0') ret.add(cut(s));
            else ret.add(s);
        }
        ret.sort((a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });
        for(String s : ret) out.println(s);


        out.flush();
        out.close();
    }
}