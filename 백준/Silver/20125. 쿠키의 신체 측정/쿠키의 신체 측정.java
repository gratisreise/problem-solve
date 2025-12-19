import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int n;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean isOut(int x, int y){
        return x < 0 || y < 0 || y >= n || x >= n;
    }
    static int leftArm(int x, int y){
        int cnt = 0;
        while(!isOut(x, y)){
            int nx = x + dx[0];
            int ny = y + dy[0];

            if(isOut(nx, ny) || board[nx][ny] != '*') break;
            x = nx; y = ny;
            cnt++;
        }
        return cnt;
    }
    static int rightArm(int x, int y){
        int cnt = 0;
        while(!isOut(x, y)){
            int nx = x + dx[2];
            int ny = y + dy[2];
            if(isOut(nx, ny) || board[nx][ny] != '*') break;
            x = nx; y = ny;
            cnt++;
        }
        return cnt;
    }
    static int leg(int x, int y){
        int cnt = 1;
        while(!isOut(x, y)){
            int nx = x + dx[1];
            int ny = y + dy[1];
            if(isOut(nx, ny) || board[nx][ny] != '*') break;
            x = nx; y = ny;
            cnt++;
        }
        return cnt;
    }
    static int[] low(int x, int y){
        while(!isOut(x, y)){
            int nx = x + dx[1];
            int ny = y + dy[1];
            if(isOut(nx, ny) || board[nx][ny] != '*') break;
            x = nx; y = ny;
        }
        return new int[]{x, y};
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());
        board = new char[n][n];
        for(int i = 0; i < n; i++){
            board[i] = in.readLine().toCharArray();
        }

        int x = -1;
        int y = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '*'){
                    x = i; y = j;
                    break;
                }
            }
            if(x != -1) break;
        }
        x++;
        int leftArm = leftArm(x, y);
        int rightArm = rightArm(x, y);
        int body = leg(x+1, y);
        int[] low = low(x, y);
        int leftLeg = leg(low[0]+1, low[1]-1);
        int rightLeg = leg(low[0]+1, low[1]+1) ;

        out.printf("%d %d\n", ++x, ++y);
        out.printf("%d %d %d %d %d\n", leftArm, rightArm, body, leftLeg, rightLeg);
        out.flush();
        out.close();
    }
}