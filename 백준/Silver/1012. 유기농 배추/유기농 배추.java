import java.io.*;
import java.util.*;

public class Main{
    static int t, n, m, k, y, x, ret;
    static int[][] a, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(a[ny][nx] == 0 || visited[ny][nx] != 0) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            ret = 0;
            a = new int[n + 4][m + 4];
            visited = new int[n + 4][m + 4];

            //배추심기
            while(k-- > 0){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                a[y][x] = 1;
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(a[i][j] == 0 || visited[i][j] != 0) continue;
                    dfs(i, j); ret++;
                }
            }

            bw.write(String.valueOf(ret)+'\n');
            bw.flush();
        }

    }
}
/*
t입력
x: m, y : n, 배추위치:k
k만큼 배추 >>x >>y 들어온다.
a2차원 배열에 배추 심기
각 테스트 케이스마다 dfs로 연결컴포넌트 갯수 구하기
출력하기
 */