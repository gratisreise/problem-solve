import java.io.*;
import java.util.*;

public class Main{
    static int n, m, h, ret = (int)1e9;
    static int[][] ladder;
    static boolean check(){ //자기자신으로 오는 경우인지 확인
        for(int i = 1; i <= n; i++){
            int start = i;
            for(int j = 1; j <= h; j++){
                if(ladder[j][start] == 1) start++;
                else if(ladder[j][start - 1] == 1) start--;
            }
            if(start != i) return false;
        }
        return true;
    }
    static void go(int here, int cnt){
        if(cnt > 3 || cnt >= ret) return; //3보다 크면 그냥 리턴 현재보다 작으면 리턴
        if(check()){ // 가장 적은 사다리 횟수를 해야하니 바로 리턴
            ret = Math.min(ret, cnt);
            return;
        }
        // 가로선 긋기
        for(int i = here; i <= h; i++){
            for(int j = 1; j <= n; j++){
                if(ladder[i][j] == 1 || ladder[i][j - 1] == 1 || ladder[i][j + 1] == 1) continue;
                ladder[i][j] = 1;
                go(i, cnt + 1);
                ladder[i][j] = 0;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new int[h + 4][n + 4];
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
        }
        go(1, 0);
        bw.write(""+((ret == (int)1e9) ? -1 : ret)+'\n');
        bw.flush();
    }
}
