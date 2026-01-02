import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int o = -1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                o = Math.max(o, board[i][j]);
            }
        }
        int[][][] cube = new int[n][m][o];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int z = board[i][j];
                for(int k = 0; k < z; k++){
                    cube[i][j][k] = 1;
                }
            }
        }
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < o; k++){
                    if(cube[i][j][k] == 0) continue;
                    for(int d = 0; d < 6; d++){
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        int nz = k + dz[d];
                        if(ny < 0 || nx < 0 || nz < 0 || ny >= n || nx >= m || nz >= o){
                            ret++; continue;
                        }
                        if(cube[ny][nx][nz] == 0) ret++;
                    }
                }
            }
        }
        System.out.println(ret);

        out.flush();
        out.close();
    }
}