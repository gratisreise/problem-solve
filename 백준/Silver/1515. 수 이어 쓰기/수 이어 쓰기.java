import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

         char[] s = in.readLine().toCharArray();
         int l = s.length;
         int idx = 0;
         int num = 1;

         while(true){
             String now = "" + num;
             for(int i = 0; i < now.length(); i++){
                if(idx < l && now.charAt(i) == s[idx]){
                    idx++;
                }
             }
             if(idx == l) {
                 out.println(now);
                 break;
             }
             num++;
         }

        out.flush();
        out.close();
    }
}
/*
숫자를 늘려가면서 각문자열에 맞는 포인터를 넘겨주기
*/