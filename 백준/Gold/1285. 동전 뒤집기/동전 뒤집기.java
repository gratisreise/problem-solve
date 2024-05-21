import java.io.*;
import java.util.*;

public class Main{
    static int n, ret = (int)1e9;
    static int[] a = new int[24];
    static void go(int idx){
        if(idx == n){
            int sum = 0;
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
        go(idx + 1);
        a[idx] = ~a[idx];
        go(idx + 1);
        a[idx] = ~a[idx];
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
                if(c[j] == 'T') a[i] += (1 << j);
            }
        }
        go(0);
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}
/*
1. 배열을 2진수의 int배열로 저장한다. (T는 1로)
2. 완전탐색
    2-1. 행기준 뒤집기
    2-2. 행기준 안 뒤집기
3. n 도달하면
4. 열 기준으로 앞뒤 갯수 세기
    4-1.앞이 더 많으면 sum += n - cnt;
    4-2.뒤가 더 많으면 sum += n;
5. ret = Math.min(ret, sum);
 */
