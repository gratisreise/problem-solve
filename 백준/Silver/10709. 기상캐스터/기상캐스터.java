import com.sun.security.jgss.GSSUtil;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] board = new char[h][w];
        int[][] ret = new int[h][w];
        for(int[] row : ret){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < h; i++){
            char[] row = in.readLine().toCharArray();
            board[i] = row;
        }


        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(board[i][j] == 'c'){
                    int now = 1;
                    ret[i][j] = 0;
                    while(j < w-1 && board[i][j+1] == '.'){
                        ret[i][j + 1] = now;
                        now++;
                        j++;
                    }
                }
            }
        }

        var sb = new StringBuilder();
        for(int i = 0; i < h; i++){
            for(int j=  0; j < w; j++){
                sb.append(ret[i][j]);
                if(j != w-1) sb.append(" ");
            }
            sb.append("\n");
        }
        out.println(sb);



        out.flush();
        out.close();
    }
}