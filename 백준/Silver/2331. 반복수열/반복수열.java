import java.io.*;
import java.util.*;

public class Main {
    static int go(int n, int p){
        int sum = 0;
        int temp = n;
        while(temp > 0){
            sum += pre(temp, p);
            temp /= 10;
        }
        return sum;
    }
    static int pre(int temp, int p){
        int num = temp % 10;
        int ret = 1;
        for(int i = 0; i < p; i++){
            ret *= num;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> mp = new HashMap<>();// 중복체크

        mp.put(n, 0);
        int idx = 1;
        int breakPoint = 0;
        while(true){
            int next = go(n, p);
            int nextIdx = mp.getOrDefault(next, -1);
            if(nextIdx != -1){
                breakPoint = nextIdx;
                break;
            }
            mp.put(next, idx);
            idx++;
            n = next;
        }
        System.out.println(breakPoint);

        out.flush();
        out.close();
    }

}