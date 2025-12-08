import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            arr[i] = in.readLine().toCharArray();
        }


        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] != 0) continue;
                ret++;
                char now = arr[i][j];
                vis[i][j] = 1;
                int tempj = j+1;
                while(now == '-' && tempj < m && arr[i][tempj] == now){
                    vis[i][tempj] = 1;
                    tempj++;
                }
                int tempi = i+1;
                while(now == '|' && tempi < n && arr[tempi][j] == now){
                    vis[tempi][j] = 1;
                    tempi++;
                }
            }

        }
        System.out.println(ret);



        out.flush();
        out.close();
    }
}