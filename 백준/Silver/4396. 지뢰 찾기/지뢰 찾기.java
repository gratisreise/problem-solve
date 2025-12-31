import com.sun.security.jgss.GSSUtil;
import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = s.charAt(j);
            }
        }
        char[][] ret= new char[n][n];
        boolean isMined = false;
        for(int i = 0; i < n; i++){
            char[] row = in.readLine().toCharArray();
            for(int j = 0; j < n; j++){
                char c = row[j];
                if(c == 'x'){
                    if(board[i][j] == '*') {
                        ret[i][j] = board[i][j];
                        isMined = true;
                    }
                    int cnt = 0;
                    for(int d = 0; d < 8; d++){
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if(ny < 0 || nx < 0 || ny >= n || nx>= n) continue;
                        if(board[ny][nx] == '*') cnt++;
                    }
                    ret[i][j] = (char)(cnt+'0');
                } else ret[i][j] = c;
            }
        }
        if(isMined){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == '*') ret[i][j] = '*';
                }
            }
        }
        var ans = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans.append(ret[i][j]);
            }
            ans.append("\n");
        }

        out.println(ans);
        
        out.flush();
        out.close();
    }
}