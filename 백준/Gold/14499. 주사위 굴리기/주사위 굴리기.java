import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] move = {
        {0, 1, 4, 5, 3, 2},//동
        {0, 1, 5, 4, 2, 3},//서
        {5, 4, 2, 3, 0, 1},//북
        {4, 5, 2, 3, 1, 0} //남
    };
    static int[] mmove(int[] dice, int dir){
        int[] d = move[dir];
        int size = dice.length;
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[d[i]] = dice[i];
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);


        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for(int i = 0; i <n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dice = new int[6];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < k; i++){
            int dir = Integer.parseInt(st.nextToken()) - 1;
            //이동
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            y = ny; x = nx;
            dice = mmove(dice, dir);

            //아래처리
            out.println(dice[4]); //윗면출력
            if(board[y][x] == 0){
                board[y][x] = dice[5];
            } else {
                dice[5] = board[y][x];
                board[y][x] = 0;
            }
        }

        out.flush();
        out.close();
    }
}