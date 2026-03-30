import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s1 = in.readLine();
        String s2 = in.readLine();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0; i < s1.length(); i++) cnt1[s1.charAt(i) - 'a']++;
        for(int i = 0; i < s2.length(); i++) cnt2[s2.charAt(i) - 'a']++;
        int ret = 0;
        for(int i = 0; i< 26; i++){
            ret += Math.abs(cnt1[i] - cnt2[i]);
        }
        out.println(ret);
        
        out.flush();
        out.close();
    }
}
/*

*/