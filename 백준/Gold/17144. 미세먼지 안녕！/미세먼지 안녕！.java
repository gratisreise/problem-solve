import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t;
    static int[][] board;
    static int[][] cleaner = new int[2][2];
    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};

    static boolean notDust(int y, int x){
        return board[y][x] == -1 || board[y][x] == 0;
    }
    static boolean isOut(int y, int x){
        return y < 0 || y >= r || x < 0 || x >= c;
    }
    static void print(int[][] arr){
        for(int[] row : arr){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    static void diffusion(){
        //임시배열 생성
        int[][] temp = new int[r][c];
        //먼지 4방향 확산
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(notDust(i, j)) continue;
                int cnt = 0; int value = board[i][j] / 5;
                for(int d = 0; d < 4; d++){
                    int ny = i + dy1[d];
                    int nx = j + dx1[d];
                    if(isOut(ny, nx) || board[ny][nx] == -1) continue;
                    temp[ny][nx] += value;
                    cnt++;
                }
                board[i][j] -= cnt* value;
            }
        }

        //해당 배열을 board배열에 적용
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                board[i][j] = board[i][j] + temp[i][j];
            }
        }
    }
    static void move1(int[][] temp){
        //현재위치에 먼지가 있으면 다음 위치로 먼지 이동
        //반시계
        int[] cleaner1 = cleaner[0];
        int d = 0;
        int y = cleaner1[0] + dy1[d];
        int x = cleaner1[1] + dx1[d];
        while(y != cleaner1[0] || x != cleaner1[1]){
            //바람이동
            int ny = y + dy1[d];
            int nx = x + dx1[d];
            if(isOut(ny, nx)) {
                d++;
                ny = y + dy1[d];
                nx = x + dx1[d];
            }
            //먼지이동
            temp[ny][nx] = board[y][x];
            //먼지제거
            if(ny == cleaner1[0] && nx == cleaner1[1]) temp[ny][nx] = -1;
            y = ny; x = nx;
        }
        //보드 변경
        d = 0;
        y += dy1[d]; x += dx1[d];
        while(y != cleaner1[0] || x != cleaner1[1]){
            int ny = y + dy1[d];
            int nx = x + dx1[d];
            if(isOut(ny, nx)) {
                d++;
                ny = y + dy1[d];
                nx = x + dx1[d];
            }
            board[y][x] = temp[y][x];
            y = ny; x = nx;
        }
    }
    static void move2(int[][] temp){
        //시계
        int[] cleaner2 = cleaner[1];
        int d = 0;
        int y = cleaner2[0] + dy2[d];
        int x = cleaner2[1] + dx2[d];
        while(y != cleaner2[0] || x != cleaner2[1]){
            //바람이동
            int ny = y + dy2[d];
            int nx = x + dx2[d];
            if(isOut(ny, nx)) {
                d++;
                ny = y + dy2[d];
                nx = x + dx2[d];
            }
            //먼지이동
            if(board[y][x] != 0) temp[ny][nx] = board[y][x];
            //먼지제거
            if(ny == cleaner2[0] && nx == cleaner2[1]) temp[ny][nx] = -1;
            y = ny; x = nx;
        }
        //보드변경
        d = 0;
        y += dy2[d]; x += dx2[d];
        while(y != cleaner2[0] || x != cleaner2[1]){
            int ny = y + dy2[d];
            int nx = x + dx2[d];
            if(isOut(ny, nx)) {
                d++;
                ny = y + dy2[d];
                nx = x + dx2[d];
            }
            board[y][x] = temp[y][x];
            y = ny; x = nx;
        }
    }
    static void move(){
        //임시배열 필요
        int[][] temp = new int[r][c];
        move1(temp);
        move2(temp);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        int idx = 0;
        board = new int[r][c];
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < c; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == -1){
                    cleaner[idx][0] = i;
                    cleaner[idx][1] = j;
                    idx++;
                }
            }
        }

        while(t-- > 0){
            diffusion();
            move();
        }
        int ret = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(notDust(i, j)) continue;
                ret += board[i][j];
            }
        }
        out.println(ret);
        out.flush();
        out.close();
    }
}