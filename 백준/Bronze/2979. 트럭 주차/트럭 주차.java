import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);
        StringTokenizer st;
        
        st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] cnt = new int[104];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j = a; j < b; j++) cnt[j]++;
        }
        int ret = 0;
        for(int i = 1; i < 100; i++){
            if(cnt[i] == 1) ret += A;
            else if(cnt[i] == 2) ret += B * 2;
            else if(cnt[i] == 3) ret += C * 3;
        }
        out.println(ret);
        out.flush();
        out.close();
    }
}