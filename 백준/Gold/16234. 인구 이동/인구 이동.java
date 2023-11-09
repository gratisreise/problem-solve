import java.util.*;

public class Main{

    static int n, L, R, sum, ret;
    static List<Pair> l = new ArrayList<>();
    static int[][] a, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Pair{
        int f, s;
        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    static void dfs(int y, int x){
        visited[y][x] = 1;
        l.add(new Pair(y, x));
        sum += a[y][x];
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            int sub = Math.abs(a[ny][nx] - a[y][x]);
            if(visited[ny][nx] != 0 || sub < L || sub > R) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        a = new int[n + 4][n + 4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
            }
        }
        while(true){
            boolean flag = false;
            visited = new int[n + 4][n + 4];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j] != 0) continue;
                    l.clear();
                    sum = 0;
                    dfs(i, j);
                    if(l.size() == 1) continue;
                    flag = true;
                    for(Pair it : l) a[it.f][it.s] = sum / l.size();
                }
            }
            if(!flag) break;
            ret++;
        }
        System.out.println(ret);
    }
}