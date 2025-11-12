import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] che = new boolean[n+1];

        int cnt = 0;
        boolean flag = false;
        for(int i = 2; i <= n; i++){
            if(!che[i]){
                cnt++;
                if (cnt == k) {
                    System.out.println(i);
                    flag = true;
                    break;
                }
                for(int j = i + i; j <= n; j += i){
                    if(!che[j]){
                        che[j] = true;
                        cnt++;
                    }
                    if (cnt == k) {
                        System.out.println(j);
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
        }

        out.flush();
        out.close();
    }
}