import java.util.*;

public class Main{

    static int n, m, ret = Integer.MIN_VALUE;
    static char[][] a;
    static int visited[][];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair> L = new ArrayList<>();
    static class Pair{
        int f, s;
        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    static void solve(){

        for(Pair p : L){
            visited = new int[n + 4][m + 4];
            bfs(p.f, p.s);
        }
    }
    static void bfs(int y, int x){
        visited[y][x] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int f = p.f;
            int s = p.s;
            for(int i = 0; i < 4; i++){
                int ny = f + dy[i];
                int nx = s + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(a[ny][nx] == 'W' || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[f][s] + 1;
                ret = Math.max(ret, visited[ny][nx] - 1);
                q.add(new Pair(ny, nx));
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n + 4][m + 4];
        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'L') L.add(new Pair(i, j));
            }
        }
        solve();
        System.out.println(ret);
    }
}

/**
 * 육지, 바다 저장
 * 최단거리(bfs) 로직
 * 지도의 최단거리중 max 판단 == ret
 * 육지 좌표의 시작점마다 bfs최대 비교
 */