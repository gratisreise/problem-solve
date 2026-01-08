import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x =x;
        }
    }
    static class Dir{
        int time; char dir;
        Dir(int time, char dir){
            this.time = time;
            this.dir = dir;
        }
    }
    static int[] dy ={-1, 0, 1, 0};
    static int[] dx ={0, 1, 0, -1};
    static boolean check(int y, int x, Deque<Point> dq){
        Deque<Point> temp = new ArrayDeque<>(dq);
        while(!temp.isEmpty()){
            Point now = temp.pollLast();
            if(now.y == y && now.x == x) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        int[][] board = new int[n+1][n+1];

        Deque<Point> snake = new ArrayDeque<>();
        snake.addLast(new Point(1, 1));

        for(int i = 0; i < k; i++){
            var st = new StringTokenizer(in.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y][x] = 1;
        }

        int L = Integer.parseInt(in.readLine());
        Queue<Dir> dirs  = new ArrayDeque<>();
        for(int i = 0; i < L; i++){
            var st = new StringTokenizer(in.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            dirs.add(new Dir(time, dir));
        }

        int d = 1; // 방향
        int ret = 0;
        while(true){

            ret++;
            //이동
            Point head = snake.getFirst();
            int ny = head.y + dy[d];
            int nx = head.x + dx[d];
            if(ny < 1 || nx < 1 || ny > n || nx > n) break;
            if(check(ny, nx, snake)) break;
            snake.addFirst(new Point(ny, nx));
            if(board[ny][nx] != 1) snake.pollLast();
            else board[ny][nx] = 0;

            //방향전환
            if(!dirs.isEmpty() && dirs.peek().time == ret){
                Dir rot = dirs.poll();
                char dir = rot.dir;
                if(dir == 'L'){
                    d = (d-1 + 4) % 4;
                } else {
                    d = (d+1) % 4;
                }
            }
        }

        out.println(ret);


        out.flush();
        out.close();
    }
}