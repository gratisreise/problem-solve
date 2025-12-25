import java.io.*;
import java.util.*;

public class Main {
    static void fill(int y, int x, int size,int[][] board, int[][] temp){
        if(size != 2){
            fill(y, x, size/2, board, temp);
            fill(y, x + size/2, size/2, board, temp);
            fill(y+ size/2, x, size/2, board, temp);
            fill(y+size/2, x+size/2, size/2, board, temp);
            return;
        }
        List<Integer> l = new ArrayList<>();
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                l.add(board[i][j]);
            }
        }
        l.sort(Comparator.reverseOrder());
        temp[y/2][x/2] = l.get(1);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int size = n;
        while(size > 1){
            int[][] temp = new int[size/2][size/2];
            fill(0, 0, size, board, temp);
            size /= 2;
            board = temp;
        }
        System.out.println(board[0][0]);

        out.flush();
        out.close();
    }
}