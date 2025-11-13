import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c - 'A']++;
        }
        int cnt1 = 0;
        String mid = "";

        for(int i = 0; i < 26; i++){
            if(cnt[i] % 2 == 1){
                cnt1++; mid = ""+ (char)(i + 'A');
                cnt[i]--;
            }
        }
        if(cnt1 > 1) {
            out.println("I'm Sorry Hansoo\n");
            out.flush();
            out.close();
            return;
        }

        var ret = new StringBuilder();
        for(int i = 'Z'; i >= 'A'; i--){
            for(int j = 0; j < cnt[i - 'A']; j += 2){
                ret.append((char)i);
                ret= new StringBuilder(""+(char)i).append(ret);
            }
        }
        if(cnt1 > 0){
            ret.insert(ret.length()/2, mid);
        }
        System.out.println(ret);

        out.flush();
        out.close();
    }
}