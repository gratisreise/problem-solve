import java.util.*;

public class Main {
    static int n, m, retT, retC;
    static int[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair> l = new ArrayList<>();
    static class Pair{
        int f, s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    static void dfs(int y, int x){
        visited[y][x] = 1;
        if(a[y][x] == 1){
            l.add(new Pair(y, x));
            return;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n|| nx >= m) continue;
            if(visited[ny][nx] != 0) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }
        while(true){
            visited = new int[n + 1][m + 1];
            l.clear();
            dfs(0, 0);
            if(l.size() == 0) break;
            for(Pair p : l){
                a[p.f][p.s] = 0;
            }
            retT++; retC = l.size();
        }
        System.out.println(retT + "\n" + retC);

    }
}