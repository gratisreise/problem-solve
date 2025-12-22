import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int limit = 104;
        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[limit][limit];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    board[x][y]++;
                }
            }
        }
        int ret = 0;
        for(int i = 1; i <= 100; i++){
            for(int j = 0; j <= 100; j++){
                if(board[i][j] > m) ret++;
            }
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}