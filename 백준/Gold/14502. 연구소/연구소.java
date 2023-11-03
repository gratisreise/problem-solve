import java.util.*;

public class Main {
    static int n, m, ret = -1;
    static int[][] a = new int[10][10];
    static int[][] visited = new int[10][10];
    static int[][] tempArr = new int[10][10];
    static ArrayList<Pair> vir = new ArrayList<>();
    static ArrayList<Pair> wall = new ArrayList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void copy0(int[][] arr){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                arr[i][j] = 0;
            }
        }
    }

    static void dfs(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (a[ny][nx] == 1 || visited[ny][nx] != 0) continue;
            dfs(ny, nx);
        }
    }

    static void solve(){
        int cnt = 0;
        copy0(visited);
        // 바이러스 퍼짐
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 2 && visited[i][j] == 0){
                    dfs(i, j);
                }
            }
        }
        // 바이러스 퍼진 후 안전지대 확인
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0 && visited[i][j] == 0){
                    cnt++;
                }
            }
        }
        ret = Math.max(ret, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2) vir.add(new Pair(i, j));
                if (a[i][j] == 0) wall.add(new Pair(i, j));
            }
        }

        for(int i = 0; i < wall.size(); i++){
            for(int j = 0; j < i; j ++){
                for(int k = 0; k < j; k++){
                    a[wall.get(i).first][wall.get(i).second] = 1;
                    a[wall.get(j).first][wall.get(j).second] = 1;
                    a[wall.get(k).first][wall.get(k).second] = 1;
                    solve();
                    a[wall.get(i).first][wall.get(i).second] = 0;
                    a[wall.get(j).first][wall.get(j).second] = 0;
                    a[wall.get(k).first][wall.get(k).second] = 0;
                }
            }
        }
        System.out.println(ret);
    }

    


}
