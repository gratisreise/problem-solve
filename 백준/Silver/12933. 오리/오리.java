import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();
        int n = s.length();
        if(n % 5 != 0 || s.charAt(n -1) != 'k'){
            System.out.println(-1);
            return;
        }

        int q = 0, u = 0, a = 0, c = 0, k = 0;
        int maxDucks = 0; // 같이 우는 오리 max
        int curDucks = 0; // 현재 같이 우는 오리

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            boolean flag = false;

            if(ch == 'q'){
                q++;
                curDucks++;
                maxDucks = Math.max(curDucks, maxDucks);
            } else if(ch == 'u'){
                if(q > u) u++;
                else flag = true;
            } else if(ch == 'a'){
                if(u > a) a++;
                else flag = true;
            } else if(ch == 'c'){
                if(a > c) c++;
                else flag = true;
            } else if(ch == 'k'){
                if(c > k) {
                    k++;
                    curDucks--;
                } else flag = true;
            }
            if (flag) {
                System.out.println(-1);
                return;
            }

        }

        if(q == u && u == a && a == c && c == k){
            System.out.println(maxDucks);
        } else {
            System.out.println(-1);
        }

        out.flush();
        out.close();
    }
}