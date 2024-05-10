import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] a, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void dfs(int y, int x, int d){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || nx >= n || nx >= n) continue;
            if(a[ny][nx] <= d || visited[ny][nx] != 0) continue;
            dfs(ny, nx, d);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n + 4][n + 4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ret = -1;
        for(int d = 0; d <= 100; d++){
            int cnt = 0;
            visited = new int[n + 4][n + 4];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(a[i][j] <= d || visited[i][j] != 0) continue;
                    dfs(i, j, d); cnt++;
                }
            }
            ret = Math.max(cnt, ret);
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}
/*
1. 높이정보 2차원 배열에 저장
2. 0 <= d <= 100 범위에서 최대 영역갯수 체크
3. 내리는양에 따라 cnt, 방문배열 재할당
4. 맵을 돌면서 dfs 갯수 체크
5. 최대값비교
6. 최댓값 출력
 */