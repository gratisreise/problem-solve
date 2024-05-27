import java.util.*;
import java.io.*;


public class Main {
    static int n, p, s, e, ret, sum;
    static int[] a;
    static boolean[] che;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());;
        che = new boolean[n + 4];
        a = new int[n/2 + 4];
        for(int i = 2; i <= n; i++){
            if(che[i]) continue;
            for(int j = 2 * i; j <= n; j += i){
                che[j] = true;
            }
        }
        //p는 0이니깐 ++해주며 인덱스 이동
        //p는 나중에도 사용되므로 소중하게대하자
        for(int i = 2; i <= n; i++){
            if(!che[i]) a[p++] = i;
        }
        //lo는 0 hi는 0
        while(true){
            // sum이 n보다 크면 시작점 소수 빼기
            if(sum >= n) sum -= a[s++];
            // 끝점이 종점과 같으면 break
            else if(e == p) break;
            // 끝점이 종점이
            else sum += a[e++];
            // sum이랑 같으면 갯수세주기
            if(sum == n) ret++;
        }

        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}