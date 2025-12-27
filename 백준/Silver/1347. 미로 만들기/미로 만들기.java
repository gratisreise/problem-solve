import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {1, 0, -1, 0};
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

        int n = Integer.parseInt(in.readLine());
        char[] cmd = in.readLine().toCharArray();
        int d = 0;
        int x = 0; int y = 0;
        int maxX = 0; int minX = 0; int maxY = 0; int minY = 0;
        List<Point> points = new ArrayList<>();
        points.add(new Point(y, x));
        for(char c : cmd){
            if(c == 'R'){
                d = (d+3) % 4;
            } else if(c == 'L'){
                d = (d+1) % 4;
            } else {
                int ny = y + dy[d];
                int nx = x + dx[d];
                points.add(new Point(ny, nx));
                maxX = Math.max(maxX, nx);
                maxY = Math.max(maxY, ny);
                minX = Math.min(minX, nx);
                minY = Math.min(minY, ny);
                x = nx;
                y = ny;
            }
        }
        int h = Math.abs(maxY - minY) + 1;
        int w = Math.abs(maxX - minX) + 1;
        char[][] board = new char[h][w];
        for(char[] row: board){
            for(int i = 0; i < row.length; i++){
                row[i] = '#';
            }
        }
        int addX = Math.abs(minX);
        int addY = Math.abs(minY);
        for(Point p : points){
            int cy = p.y;
            int cx = p.x;
            board[cy+addY][cx+addX] = '.';
        }
        var ret = new StringBuilder();
        for(char[] row : board){
            ret.append(new String(row));
            ret.append("\n");
        }
        out.println(ret);
        out.flush();
        out.close();
    }
}