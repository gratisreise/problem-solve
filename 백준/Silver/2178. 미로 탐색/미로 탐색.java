import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int y; int x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            String line = in.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }
        visited[0][0] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(visited[ny][nx] != 0 || board[ny][nx] == 0) continue;
                q.offer(new Pair(ny, nx));
                visited[ny][nx] = visited[y][x] + 1;
            }
        }
        out.println(visited[n-1][m-1]);


        out.flush();
        out.close();
    }
}