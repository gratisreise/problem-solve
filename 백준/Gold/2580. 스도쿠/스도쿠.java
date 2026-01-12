import java.io.*;
import java.util.*;

public class Main {
    static int n = 9;
    static int[][] board = new int[n][n];
    static List<Point> points = new ArrayList<>();
    static class Point{
        int y; int x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static boolean fill(int idx){
        if(idx == points.size()) return true;

        Point now  = points.get(idx);

        for(int i = 1; i <= n; i++){
            if(isValid(now.y, now.x, i)){ //가로세로,3*3체크
                board[now.y][now.x] = i;
                if(fill(idx + 1)) return true;
                board[now.y][now.x] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int y, int x, int num){
        for(int i = 0; i < n; i++){
            if(board[y][i] == num) return false;
            if(board[i][x] == num) return false;
        }

        for(int i= 0 ; i < n; i +=3){
            for(int j = 0; j < n; j += 3){
                if(i <= y && y < i+3 && j <= x && x < j+3){
                    if(!nemo(i, j, num)) return false;
                    else return true;
                }
            }
        }
        return true;
    }
    static boolean nemo(int y, int x, int num){
        for(int i = y; i < y + 3; i++){
            for(int j = x; j < x + 3; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) points.add(new Point(i, j));
            }
        }
        
        fill(0);
        var ret = new StringBuilder();
        for(int[] row : board){
            for(int i = 0; i < n; i++){
                ret.append(row[i]);
                if(i < n-1) ret.append(" ");
            }
            ret.append("\n");
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}
/*

1. 모든 포인트를 리스트에 저장
2. 각 포인트에 들어갈 수 있느숫자의 경우는 정해짐 그 경우를 하나씩 체크하면서 넘기면서 확인


*/