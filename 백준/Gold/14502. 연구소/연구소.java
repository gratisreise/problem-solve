import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1 , 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int count(List<Point> virus){
        visited = new boolean[n][m];
        Queue<Point> q = new ArrayDeque<>();
        for(Point p : virus){
            visited[p.y][p.x] = true;
            q.offer(p);
        }
        while(!q.isEmpty()){
            Point now = q.poll();
            int cy = now.y;
            int cx = now.x;
            for(int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(visited[ny][nx] || board[ny][nx] == 1) continue;
                visited[ny][nx] = true;
                q.offer(new Point(ny, nx));
            }
        }
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] != 0 || visited[i][j]) continue;
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        List<Point> virus = new ArrayList<>();
        List<Point> empty = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) empty.add(new Point(i, j));
                else if(board[i][j] == 2) virus.add(new Point(i, j));
            }
        }
        int emp = empty.size();

        int ret = 0;
        for(int i = 0; i < emp; i++){
            for(int j = i+1; j < emp; j++){
                for(int k = j + 1; k < emp; k++){
                    board[empty.get(i).y][empty.get(i).x] = 1;
                    board[empty.get(j).y][empty.get(j).x] = 1;
                    board[empty.get(k).y][empty.get(k).x] = 1;
                    ret = Math.max(ret, count(virus));
                    board[empty.get(i).y][empty.get(i).x] = 0;
                    board[empty.get(j).y][empty.get(j).x] = 0;
                    board[empty.get(k).y][empty.get(k).x] = 0;
                }
            }
        }

        out.println(ret);
        out.flush();
        out.close();
    }
}