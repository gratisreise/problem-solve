import java.io.*;
import java.util.*;

public class Main {
    static int[] dy ={0, -1, 0, 1};
    static int[] dx ={1, 0, -1, 0};
    static int[][] board = new int[101][101];
    static void fill(int x, int y, int d, int g){
        List<Integer> l = new ArrayList<>();
        l.add(d);
        board[y][x]++;
        y += dy[d]; x += dx[d];
        board[y][x]++;
        for(int k = 0; k < g; k++){
            for(int i = l.size() - 1; i >= 0; i--){
                int dd = (l.get(i) + 1) % 4;
                l.add(dd);
                y += dy[dd]; x += dx[dd];
                board[y][x]++;
            }
        }
    }
    static boolean check(int y, int x){
        return board[y][x] > 0 && board[y+1][x] > 0 && board[y][x+1] > 0 && board[y+1][x+1] > 0;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());

        while(t-- > 0){
            var st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            fill(x,y,d,g);
        }

        int ret = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(check(i,j)) ret++;
            }
        }

        out.println(ret);


        out.flush();
        out.close();
    }
}