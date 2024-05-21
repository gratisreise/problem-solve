import java.io.*;
import java.util.*;

public class Main{
    static int n, ret = (int) 1e9;
    static int[] a = new int[24];
    static void go(int here){
        if(here == n){
            int sum = 0;
            // 각 열 지정
            for(int i = 1; i <= (1 << (n - 1)); i *= 2){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if((a[j] & i) != 0) cnt++;
                }
                sum += Math.min(cnt, n - cnt);
            }
            ret = Math.min(ret, sum);
            return;
        }
//        System.out.println("----------");
//        System.out.println("here :: " + here);
//        for(int i = 0; i < n; i++){
//            System.out.println(a[i]);
//        }
//        System.out.println("---------");
        go(here + 1);
        a[here] = ~a[here];
        go(here + 1);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < n; j++){
                //앞은 1로 저장
                if(c[j] == 'T') a[i] += (1 << j);
            }
        }

        go(0);
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}