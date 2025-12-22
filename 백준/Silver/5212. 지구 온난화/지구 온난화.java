import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] board = new char[r][c];

        for(int i = 0; i < r; i++){
            board[i]  = in.readLine().toCharArray();
        }
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == 'X'){
                    int cnt = 0;
                    for(int d = 0; d < 4; d++){
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                            cnt++; continue;
                        }
                        if(board[ny][nx] != 'X') cnt++;
                    }
                    if(cnt  >= 3){
                        points.add(new Point(i, j));
                    }
                }
            }
        }
        for(Point p : points){
            board[p.y][p.x] = '.';
        }
        int minY = r+4, maxY = -1, minX = c + 5, maxX = -1;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == 'X'){
                    minY = Math.min(i, minY);
                    maxY = Math.max(i, maxY);
                    minX = Math.min(j, minX);
                    maxX = Math.max(j, maxX);
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for(int i = minY; i <= maxY; i++){
            for(int j = minX; j <= maxX; j++){
                ret.append(board[i][j]);
            }
            ret.append("\n");
        }

        out.println(ret);


        out.flush();
        out.close();
    }
}
/*
X.
50년후 지도
출력의 되는 형태의 크기도 줄어듬
모든 섬이 표현되는 가장 작은 직사각형 형태 => 상하좌우 끝점 구해서 출력
인접 3or4칸 바다면 사라짐
*/