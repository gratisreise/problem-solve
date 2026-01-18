import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int ret = 11;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean isWall(int ny, int nx){
        return board[ny][nx] == '#';
    }
    static boolean isHole(int ny, int nx){
        return board[ny][nx] == 'O';
    }
    static void go(int ry, int rx, int by, int bx, int cnt){
        if(cnt >= 10 || cnt >= ret) return;

        for(int d = 0; d < 4; d++){
            //빨간 구슬 이동
            int nry = ry, nrx = rx;
            while(!isWall(nry+dy[d], nrx + dx[d])){
                nry += dy[d];
                nrx += dx[d];
                if(isHole(nry, nrx)) break;
            }

            //파랑 구슬 이동
            int nby = by, nbx = bx;
            while(!isWall(nby + dy[d], nbx + dx[d])){
                nby += dy[d];
                nbx += dx[d];
                if(isHole(nby, nbx)) break;
            }
            //파란구슬 구멍에 빠짐
            if(isHole(nby, nbx)) continue;

            if(isHole(nry, nrx)){
                ret = Math.min(ret, cnt + 1);
                return;
            }
            if(nry == nby && nrx == nbx){
                int redDist = Math.abs(nry - ry) + Math.abs(nrx - rx);
                int blueDist = Math.abs(nby - by) + Math.abs(nbx - bx);

                if(redDist > blueDist){
                    nry -= dy[d];
                    nrx -= dx[d];
                } else {
                    nby -= dy[d];
                    nbx -= dx[d];
                }
            }
            go(nry, nrx, nby, nbx, cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        int ry = 0, rx = 0, by = 0, bx = 0;
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'B') {
                    by = i; bx = j;
                } else if(board[i][j] == 'R'){
                    ry = i; rx = j;
                }
            }
        }

        go(ry, rx, by, bx, 0);

        if(ret == 11) out.println(-1);
        else out.println(ret);

        out.flush();
        out.close();
    }
}