import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] board;
    static int n;
    static int ret = -1;

    static void check(int y, int x){
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(board[y][x] == board[ny][nx]) continue;
            swap(y, x, ny, nx);
            count();
            swap(y, x, ny, nx);
        }
    }

    static void swap(int y, int x, int ny, int nx){
        char temp = board[y][x];
        board[y][x] = board[ny][nx];
        board[ny][nx] = temp;
    }

    static void count(){
        //행 체크
        for(int i = 0; i < n; i++){
            int cur = 1;
            for(int j = 0; j < n-1; j++){
                if(board[i][j] == board[i][j+1]){
                    cur++;
                } else {
                    ret = Math.max(ret, cur);
                    cur = 1;
                }
            }
            ret = Math.max(ret, cur);
        }

        //열 체크
        for(int i = 0; i < n; i++){
            int cur = 1;
            for(int j = 0; j < n-1; j++){
                if(board[j][i] == board[j+1][i]){
                    cur++;
                } else {
                    ret = Math.max(ret, cur);
                    cur = 1;
                }
            }
            ret = Math.max(ret, cur);
        }
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());
        board = new char[n][n];
        for(int i = 0; i < n; i++){
            char[] row = in.readLine().toCharArray();
            for(int j = 0; j < n; j++){
                board[i][j] = row[j];
            }
            if(ret == n) break;
        }

        count();

        if (ret == n) {
            System.out.println(ret);
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                check(i, j);
                if(ret == n){
                    System.out.println(ret);
                    return;
                }
            }
        }

        System.out.println(ret);

        out.flush();
        out.close();
    }
}