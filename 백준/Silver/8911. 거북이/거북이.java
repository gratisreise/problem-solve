import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++){
            char[] crr = in.readLine().toCharArray();
            int minX = 0, maxX = 0, maxY = 0, minY = 0;
            int y = 0, x = 0;
            int dir = 0;
            for(char c : crr){
                int ny = y, nx = x;
                if(c == 'F'){
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                } else if(c == 'B'){
                    ny = y - dy[dir];
                    nx = x - dx[dir];
                } else if(c == 'L'){
                    dir = (dir+1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
                minX = Math.min(minX, nx);
                minY = Math.min(minY, ny);
                maxX = Math.max(maxX, nx);
                maxY = Math.max(maxY, ny);
                y = ny;
                x = nx;
            }
            int height = maxY - minY;
            int width = maxX - minX;
            int area = width * height;
            out.println(area);
        }



        out.flush();
        out.close();
    }
}