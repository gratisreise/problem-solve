import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int y; int x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int target = Integer.parseInt(in.readLine());
        Point now = new Point(n/2, n/2);

        int[][] arr = new int[n][n];
        int len = 1;
        int cnt = 0; // 현재길이로 채운 횟수
        int dir = 0; // 방향
        int num = 1; // 채울 숫자의 크기
        arr[now.y][now.x] = 1;
        int retY = now.y, retX = now.x; // 타겟 1인 경우 고려
        while(true){
            boolean flag = false;
            int cy = now.y;
            int cx = now.x;
            for(int i = 0; i < len; i++){
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                if(ny < 0 || nx < 0 || ny >= n || nx >= n){
                    flag = true;
                    break;
                }
                num++;
                arr[ny][nx] = num;
                if(num == target){
                    retY = ny;
                    retX = nx;
                }
                cy = ny;
                cx = nx;
            }
            now.y = cy;
            now.x = cx;
            if(flag) break;
            cnt++;
            if(cnt == 2){
                cnt = 0;
                len++;
            }
            dir = (dir+1) % 4;
        }
        retY++;
        retX++;
        var ret = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j <n; j++){
                ret.append(arr[i][j]);
                if(j != n -1) ret.append(" ");
            }
            ret.append("\n");
        }
        ret.append(retY).append(" ").append(retX);
        System.out.println(ret);

        out.flush();
        out.close();
    }
}