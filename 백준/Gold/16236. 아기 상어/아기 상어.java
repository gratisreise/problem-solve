import java.io.*;
import java.util.*;

public class Main {
    static class Baby{
        int y; int x; int size; int eat;
        Baby(int y, int x, int size, int eat){
            this.y = y;
            this.x = x;
            this.size = size;
            this.eat = eat;
        }
        void move(Point p){
            this.y = p.y;
            this.x = p.x;
        }
    }
    static class Point{
        int y; int x; int dist;
        Point(int y, int x, int dist){
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
        Point(Baby baby, int dist){
            this.y = baby.y;
            this.x = baby.x;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[][] board = new int[n][n];

        Baby baby = new Baby(0, 0, 2, 0);
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j= 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9){
                    board[i][j] = 0;
                    baby = new Baby(i,j,2, 0);
                }
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        int ret = 0;
        while(true){
            PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->{
                if(a.dist == b.dist){
                    if(a.y == b.y){
                        return a.x - b.x;
                    } return a.y - b.y;
                } return a.dist - b.dist;
            });
            Queue<Point> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];
            q.offer(new Point(baby, 0));
            visited[baby.y][baby.x] = true;
            while(!q.isEmpty()){
                Point now = q.poll();
                int y = now.y;
                int x = now.x;
                int dist = now.dist;
                for(int d = 0; d < 4; d++){
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    if(board[ny][nx] > baby.size || visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    //물고기
                    if(board[ny][nx] > 0 && board[ny][nx] < baby.size) {
                        pq.offer(new Point(ny, nx, dist + 1));
                    }
                    q.offer(new Point(ny, nx, dist+1));
                }
            }
            if(pq.isEmpty()){
                out.println(ret);
                break;
            } else {
                Point now = pq.poll();
                baby.eat++;
                if(baby.eat == baby.size){
                    baby.eat = 0; baby.size++;
                }
                baby.move(now);
                board[now.y][now.x] = 0;
                ret += now.dist;
            }
        }


        out.flush();
        out.close();
    }
}