import java.util.*;

public class Main{
    static int n, l, r, sum, ret;
    static int[][] a = new int[104][104];
    static List<Pair> L = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static void dfs(int y, int x){
        visited[y][x] = 1;
        sum += a[y][x];
        L.add(new Pair(y, x));
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(visited[ny][nx] != 0) continue;
            int sub = Math.abs(a[ny][nx] - a[y][x]);
            if(sub < l || sub > r) continue;
            dfs(ny, nx);
        }
    }
    static int[][] visited;
    static class Pair{
        int f, s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
            }
        }

        while(true){
            boolean flag = false;
            visited = new int[n + 1][n + 1];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j] != 0) continue;
                    L.clear();
                    sum = 0;
                    dfs(i, j);
                    if(L.size() == 1) continue;
                    for(Pair p : L){
                        a[p.f][p.s] = sum / L.size();
                        flag = true;
                    }
                }
            }
            if(!flag) break;
            ret++;
        }
        System.out.println(ret);
    }
}