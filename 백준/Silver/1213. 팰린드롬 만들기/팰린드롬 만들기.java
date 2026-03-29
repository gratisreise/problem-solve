import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int[] cnt = new int[300];
        String s = in.readLine();
        for(char c : s.toCharArray()){
            cnt[c]++;
        }
        int cut = 0, mid = -1;
        var pre = new StringBuilder();
        var suf = new StringBuilder();
        for(int i = 'Z'; i >= 'A'; i--){
            if(cnt[i] % 2 == 1){
                cut++; cnt[i]--; mid = i;
            }
            for(int j = 0; j < cnt[i]; j += 2){
                pre.append((char)i);
                suf.append((char)i);
            }
        }

        if(cut > 1) out.println("I'm Sorry Hansoo");
        else{
            var ret = new StringBuilder();
            ret.append(pre.reverse());
            if(cut == 1) ret.append((char)mid);
            ret.append(suf);
            out.println(ret);
        }

        out.flush();
        out.close();
    }
}