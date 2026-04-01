import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static String quad(int y, int x, int size){
        if(size == 1) return board[y][x]+"";
        char a = board[y][x];
        var ret = new StringBuilder();
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(board[i][j] != a){
                    ret.append("(");
                    ret.append(quad(y, x, size / 2));
                    ret.append(quad(y, x + size/2, size/2));
                    ret.append(quad(y+size/2, x, size/2));
                    ret.append(quad(y+size/2, x + size/2, size/2));
                    ret.append(")");
                    return ret.toString();
                }
            }
        }
        return ""+a;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        board = new char[n][n];

        for(int i = 0; i < n; i++){
            board[i] = in.readLine().toCharArray();
        }

        out.println(quad(0, 0, n));


        out.flush();
        out.close();
    }
}