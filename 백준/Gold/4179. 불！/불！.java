import java.io.*;
import java.util.*;

public class Main{
    static final int INF = (int)1e9;
    static class Pair{
        int y, x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int n, m, sy, sx;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] a;
    static int[][] vis_f, vis_p;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new char[n + 4][m + 4];
        vis_f = new int[n + 4][m + 4];
        vis_p = new int[n + 4][m + 4];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                a[i][j] = c[j];
                vis_f[i][j] = INF;
                vis_p[i][j] = INF;
                if(a[i][j] == 'J'){
                    vis_p[i][j] = 1;
                    sy = i; sx = j;
                } else if(a[i][j] == 'F'){
                    vis_f[i][j] = 1;
                    q.add(new Pair(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(a[ny][nx] =='#' || vis_f[ny][nx] != INF) continue;
                vis_f[ny][nx] = vis_f[y][x] + 1;
                q.add(new Pair(ny, nx));
            }
        }

        q.add(new Pair(sy, sx));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            if(y == 0 || x == 0 || y == n-1 || x == m-1){
                bw.write(String.valueOf(vis_p[y][x])+'\n');
                bw.flush();
                return;
            }
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(a[ny][nx] =='#' || vis_p[ny][nx] != INF) continue;
                if(vis_f[ny][nx] <= vis_p[y][x] + 1) continue;
                vis_p[ny][nx] = vis_p[y][x] + 1;
                q.add(new Pair(ny, nx));
            }
        }
        bw.write("IMPOSSIBLE\n");
        bw.flush();
    }
}
/*
불에 타기전에 탈출 여부, 얼마나 빨리
불 최단 거리 배열, 사람 최단 거리 배열
 */