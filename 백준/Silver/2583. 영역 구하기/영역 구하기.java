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
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int n, m;
    static int dfs(int y, int x){
        var stk = new ArrayDeque<Pair>();
        stk.addLast(new Pair(y, x));
        visited[y][x] = true;
        int cnt = 0 ;
        while(!stk.isEmpty()){
            Pair p = stk.pollLast();
            int cy = p.y;
            int cx = p.x;
            cnt++;
            for(int d = 0; d < 4; d++){
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                if(board[ny][nx] == 1 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                stk.addLast(new Pair(ny, nx));
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        visited = new boolean[m][n];

        //색칠
        for(int i = 0 ; i < k; i++){
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){
                    board[y][x] = 1;
                }
            }
        }

        //갯수세기
        int ret = 0;
        var ll = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1 || visited[i][j]) continue;
                ll.add(dfs(i, j)); ret++;
            }
        }
        ll.sort((a, b) -> a-b);
        out.println(ret);
        for(int i : ll) out.print(i + " ");

        out.flush();
        out.close();
    }
}