import java.io.*;
import java.util.*;

public class Main{
    static int n, ret = (int) 1e9;
    static int[][] a, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static boolean check(int y, int x){
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(visited[ny][nx] != 0) return false;
        }
        return true;
    }
    static int hap(int y, int x){
        visited[y][x] = 1;
        int sum = a[y][x];
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = 1;
            sum += a[ny][nx];
        }
        return sum;
    }
    static void clear(int y, int x){
        visited[y][x] = 0;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = 0;
        }
    }
    static void go(int cnt, int sum){
        if(cnt == 3){
            ret = Math.min(ret, sum);
            return;
        }
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(check(i, j)){
                    go(cnt + 1, sum + hap(i, j));
                    clear(i, j);
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0);

        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}