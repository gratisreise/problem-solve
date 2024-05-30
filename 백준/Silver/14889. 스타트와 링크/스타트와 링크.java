import java.io.*;
import java.util.*;

public class Main{
    static final int INF =  1_000_000_000;
    static int n;
    static int[][] s;
    static int go(List<Integer> a, List<Integer> b){
        int ret = 0;
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n / 2; j++){
                if(i == j) continue;
                ret += s[a.get(i)][a.get(j)] - s[b.get(i)][b.get(j)];
            }
        }

        return Math.abs(ret);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = new int[n + 4][n + 4];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ret = INF;
        for(int i  = 0; i < (1 << n); i++){
            //비트 카운트
            if(Integer.bitCount(i) != n / 2) continue;
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();

            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0) start.add(j);
                else link.add(j);
            }
            ret = Math.min(ret, go(start, link));
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
1. 비트 마스킹 이용해서 팀이 될 수 있는 부분집하의 갯수 구한다.
2. 팀마다 비용계산한다.
3. 계산한 결과값을 비교한다.
*/