import java.io.*;
import java.util.*;

public class Main {
    static boolean isPossible(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int cnt1[] = new int[26];
        int cnt2[] = new int[26];
        for(int i = 0; i < s1.length(); i++){
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            if (isPossible(s1, s2)) out.println("Possible");
            else out.println("Impossible");
        }


        out.flush();
        out.close();
    }
}