import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int n, m;
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean isMelt(int y, int x){
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(board[ny][nx] == 0) return true;
        }
        return false;
    }
    static boolean check(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1) return false;
            }
        }
        return true;
    }
    static void fill(List<Point> points){
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        while(!q.isEmpty()){
            Point now = q.poll();
            int y = now.y;
            int x = now.x;
            if(board[y][x] == 1){
                points.add(new Point(y, x));
                continue;
            }
            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny < 0 || nx < 0|| ny >= n || nx >= m) continue;
                if(visited[ny][nx] != 0) continue;
                q.add(new Point(ny, nx));
                visited[ny][nx] = 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int prev = 0; // 녹인 갯수 = 한시간전의 갯수
        while(true){
            //보드순회하면서 녹일치즈 좌표저장
            List<Point> points = new ArrayList<>();

            fill(points);

            prev = points.size();
            //녹이기
            for(Point p : points) board[p.y][p.x] = 0;
            time++;
            //보드 치즈 체크 후 멈추기
            if(check()) break;
        }
        out.println(time);
        out.println(prev);
        //출력
        out.flush();
        out.close();
    }
}