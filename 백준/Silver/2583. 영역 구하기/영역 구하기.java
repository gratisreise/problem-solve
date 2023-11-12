import java.util.*;

public class Main{
    static int n, m, k;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Integer> l = new ArrayList<>();
    static int dfs(int y, int x){
        visited[y][x] = 1;
        int ret = 1;
        for(int i = 0; i < 4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 | ny >= m || nx >= n) continue;
            if(a[ny][nx] == 1 || visited[ny][nx] != 0) continue;
            ret += dfs(ny, nx);
        }
        return ret;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[m + 1][n + 1];
        visited = new int[m + 1][n + 1];
        while(k-- > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    a[y][x] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 1 || visited[i][j] != 0) continue;
                l.add(dfs(i, j));
            }
        }
        Collections.sort(l);
        System.out.println(l.size());
        for(int i : l) System.out.print(i + " ");
    }
}