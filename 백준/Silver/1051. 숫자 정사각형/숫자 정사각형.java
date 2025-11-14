import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean check(int y, int x, int size){
        Set<Integer> set = new HashSet<>();
        set.add(board[y][x]);
        set.add(board[y+size][x]);
        set.add(board[y][x+size]);
        set.add(board[y+size][x+size]);
        return set.size() == 1;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] sr = in.readLine().split("");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(sr[j]);
            }
        }

        int len =  Math.min(n, m);
        int ret = 1;
        for(int i = len; i >= 2; i--){
            int size = i - 1;
            for(int y = 0; y < n - size; y++){
                for(int x = 0; x < m - size; x++){
                    if(check(y, x, size)){
                        System.out.println(i*i);
                        return;
                    }
                }
            }
        }

        System.out.println(ret);

        out.flush();
        out.close();
    }
}