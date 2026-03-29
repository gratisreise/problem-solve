import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        int[] cnt = new int[26];
        for(int i = 0; i < n; i++){
            char c = in.readLine().charAt(0);
            cnt[c- 'a']++;
        }
        var ret = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(cnt[i] < 5) continue;
            ret.append((char)(i + 'a'));
        }

        if(ret.length() == 0) out.println("PREDAJA");
        else out.println(ret);

        out.flush();
        out.close();
    }
}