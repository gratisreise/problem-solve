import java.util.*;

public class Main {
    static int n, m, ret = Integer.MIN_VALUE;
    static int[][] a = new int[10][10];
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair> vir = new ArrayList<>();
    static List<Pair> wall = new ArrayList<>();
    static class Pair{
        int f, s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    static void dfs(int y, int x){ // 벽만나면 멈춤
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(a[ny][nx] == 1 || visited[ny][nx] != 0) continue;

            dfs(ny, nx);
        }
    }
    static void solve(){
        visited = new int[10][10];
        int cnt = 0;
        for(Pair p : vir) dfs(p.f, p.s);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != 0 || visited[i][j] != 0) continue;
                cnt++;
            }
        }
        ret = Math.max(ret, cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
                if(a[i][j] == 2) vir.add(new Pair(i, j));
                else if(a[i][j] == 0) wall.add(new Pair(i, j));
            }
        }

        for(int i = 0; i < wall.size(); i++){
            for(int j = 0; j < i; j++){
                for(int k = 0; k < j; k++){
                    a[wall.get(i).f][wall.get(i).s] = 1;
                    a[wall.get(j).f][wall.get(j).s] = 1;
                    a[wall.get(k).f][wall.get(k).s] = 1;
                    solve();
                    a[wall.get(i).f][wall.get(i).s] = 0;
                    a[wall.get(j).f][wall.get(j).s] = 0;
                    a[wall.get(k).f][wall.get(k).s] = 0;
                }
            }
        }
        System.out.println(ret);
    }
}