import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int n, m;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
    static void fill(int[][] visited){
        visited[0][0] = 1;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0));
        while(!q.isEmpty()){
            Point now = q.poll();
            int y = now.y;
            int x = now.x;
            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(board[ny][nx] == 1){
                    visited[ny][nx]++;
                    continue;
                }
                if(visited[ny][nx] > 0) continue;
                visited[ny][nx]++;
                q.offer(new Point(ny, nx));
            }
        }
    }
    static boolean isCheese(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1) return true;
            }
        }
        return false;
    }
    static void melt(){
        //방문배열 채우기
        int[][] visited = new int[n][m];
        fill(visited);

        //치즈좌표돌면서 녹이기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0 || visited[i][j] < 2) continue;
                board[i][j] = 0;
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

        int ret = 0;
        //치즈녹이기
        while(true){
            //치즈있는지 확인 후 종료
            if(!isCheese()) break;
            //bfs돌리면서 vis,치즈좌표 채우기 => 메서드
            melt();
            //시간추가
            ret++;
        }
        out.println(ret);
        out.flush();
        out.close();
    }
}