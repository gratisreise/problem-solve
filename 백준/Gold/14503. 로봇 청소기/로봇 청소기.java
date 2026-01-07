import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int cy = Integer.parseInt(st.nextToken());
        int cx = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while(true){
            if(!visited[cy][cx]) visited[cy][cx] = true;
            boolean flag = false;
            int k = d;
            for(int i = 0; i < 4; i++) {
                k = (k + 3) % 4;
                int ny = cy + dy[k];
                int nx = cx + dx[k];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (arr[ny][nx] == 1 || visited[ny][nx]) continue;
                flag = true;
                cy = ny;
                cx = nx;
                d = k;
                break;
            }
            if(flag) continue;
            // 후진
            int ny = cy - dy[d];
            int nx = cx - dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) break;
            if(arr[ny][nx] == 1) break;
            cy = ny;
            cx = nx;
        }

        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <m; j++){
                if(visited[i][j]) ret++;
            }
        }
        out.println(ret);


        out.flush();
        out.close();
    }
}