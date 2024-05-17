import java.io.*;
import java.util.*;

public class Main{
    static int n, m, k, ret;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] a;
    static int[][] visited;
    static int go(int y, int x, int cnt){
        if(cnt > k) return 0;
        if(y == 0 && x == m - 1 && cnt == k){
            return 1;
        }
        int ret = 0;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(a[ny][nx] == 'T' || visited[ny][nx] != 0) continue;
            visited[ny][nx] = 1;
            ret += go(ny, nx, cnt + 1);
            visited[ny][nx] = 0;
        }
        return ret;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new char[n + 4][m + 4];
        visited = new int[n + 4][m + 4];
        for(int i = 0; i < n; i++){
            a[i] = br.readLine().toCharArray();
        }
        visited[n-1][0] = 1;
        bw.write(String.valueOf(go(n - 1, 0, 1))+'\n');
//        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}
