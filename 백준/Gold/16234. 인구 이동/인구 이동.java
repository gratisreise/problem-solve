import java.io.*;
import java.util.*;

public class Main {
    static int n, L, R;
    static int[][] board, visited;
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy ={-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Point> points = new ArrayList<>();
    static int dfs(int y, int x, int[][] visited){
        int ret = 0;
        ret += board[y][x];
        points.add(new Point(y, x));
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            int cha = Math.abs(board[ny][nx] - board[y][x]);
            if(visited[ny][nx] != 0 || cha < L || cha > R) continue;
            visited[ny][nx] = 1;
            ret += dfs(ny, nx, visited);
        }
        return ret;
    }
    static boolean go(){
        visited = new int[n][n];
        boolean flag = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] != 0)continue;
                visited[i][j] = 1;
                int sum = dfs(i, j, visited);
                if(points.size() == 1) {
                    visited[i][j] = 0;
                    points.clear();
                    continue;
                }
                flag = true;
                for(Point p : points) board[p.y][p.x] = sum / points.size();
                points.clear();
            }
        }
        return flag;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        visited = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = 0;
        while(true){
            if(!go()) break;
            ret++;
        }


        out.println(ret);


        out.flush();
        out.close();
    }
}