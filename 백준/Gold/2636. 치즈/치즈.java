import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static int[][] a, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int dfs(int y, int x){
        visited[y][x] = 1;
        int ret = 0;
        if(a[y][x] == 1){
            a[y][x] = 0; visited[y][x] = 1;
            return 1;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx] != 0) continue;
            ret += dfs(ny, nx);
        }
        return ret;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n + 4][m + 4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int prev = 0;
        int ret = 0;
        while(true){
            visited = new int[n + 4][m + 4];
            int sum = dfs(0, 0);
            if(sum == 0) break;
            ret++;
            prev = sum;
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.write(String.valueOf(prev)+'\n');
        bw.flush();
    }
}
/*
1. 치즈녹이기 -> dfs 치즈 도달=> 치즈 지우고 방문처리
2. 치즈조각 칸갯수 카운트 -> 리스트에 저장한다.
3. 시간 카운트 -> while 돌리면서 카운트
 */