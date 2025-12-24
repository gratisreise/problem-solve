import java.io.*;
import java.util.*;

public class Main {
    static boolean check(List<Integer> l, int n, int m){
        int temp = 0;
        int cnt = 1;
        for(int i : l){
            if(temp + i > m){
                cnt++;
                temp = i;
            } else temp += i;
        }
        return cnt <= n;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n == 0){
            System.out.println(0);
            return;
        }
        List<Integer> l = new ArrayList<>();
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            l.add(Integer.parseInt(st.nextToken()));
        }


        int ret = 0;
        for(int i = 1; i <= n; i++){
            if(check(l, i, m)){
                System.out.println(i);
                return;
            }
        }


        out.flush();
        out.close();
    }
}