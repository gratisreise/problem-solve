import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[][] board;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int count(Point p){
        int cnt = 0;
        for(int d = 0; d < 4; d++){
            int ny = p.y + dy[d];
            int nx = p.x + dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(board[ny][nx] == 0) cnt++;
        }
        return cnt;
    }
    static boolean check1(List<Point> points){
        for(Point p: points){
            if(board[p.y][p.x] > 0) return false;
        }
        return true;
    }
    static boolean check(List<Point> points){
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;
        for(Point p : points){
            if(visited[p.y][p.x] || board[p.y][p.x] == 0) continue;
            cnt++;
            Queue<Point> q = new ArrayDeque<>();
            q.offer(p);
            visited[p.y][p.x] = true;
            while(!q.isEmpty()){
                Point pp = q.poll();
                int y = pp.y;
                int x = pp.x;
                for(int d = 0; d < 4; d++){
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if(visited[ny][nx] || board[ny][nx] == 0) continue;
                    visited[ny][nx] = true;
                    q.offer(new Point(ny, nx));
                }
            }
        }
        return cnt > 1;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        List<Point> points = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] > 0) points.add(new Point(i, j));
            }
        }

        int ret = 0;
        while(true){
            if(check1(points)){
                System.out.println(0);
                return;
            }
            if(check(points)) break;
            ret++;
            Map<Point, Integer> mp = new HashMap<>();
            for(Point p : points) {
                if(board[p.y][p.x] == 0) continue;
                mp.put(p, count(p));
            }
            for(Point p : mp.keySet()){
                board[p.y][p.x] = Math.max(board[p.y][p.x] - mp.get(p), 0);
            }
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}
/*
바다접촉칸갯수만큼 줄어듬
한덩어리의 빙신이 두덩어리 이상으로 분리되는 순간
0
다녹을 때까지 두덩어리 이상 분리x => 0출력
처음 입력이 반드시 한덩어리인가?? => 조건없음
n행[3, 300], m열[3, 300], x요소[0, 10] 요소갯수[0, 1만]
1. 보드입력 + 빙산 좌표 저장
2. 빙산 좌표를 돌면서 차감할 값을 map에 저장
3. 좌표를 돌면서 값을 차감하기


*/