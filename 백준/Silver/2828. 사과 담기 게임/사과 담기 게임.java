import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(in.readLine());
        int l= 1;
        int ret = 0;
        for(int i = 0; i < j; i++){
            int apple = Integer.parseInt(in.readLine());
            int r = l + m - 1;
            if(l <= apple && apple <= r){
                continue;
            } else if(apple < l){
                ret += l - apple;
                l = apple;
            } else {
               ret +=  apple - r;
               l = l + (apple - r);
            }
        }

        out.println(ret);
        out.flush();
        out.close();
    }
}