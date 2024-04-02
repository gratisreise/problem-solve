import java.util.*;

public class Main {
    static final int mx = 301;
    static int[] dy ={-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m, y1, x1, y2, x2;
    static int[][] visited;
    static char[][] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        y1 = sc.nextInt();
        x1 = sc.nextInt();
        y2 = sc.nextInt();
        x2 = sc.nextInt();
        y1--;x1--;y2--;x2--;
        //y랑 x 체인지
        visited = new int[n + 1][m + 1];
        a = new char[n + 1][m + 1];
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) a[i] = sc.next().toCharArray();

        q.add(1000 * y1 + x1);
        visited[y1][x1] = 1;
        int cnt = 0;

        while(a[y2][x2] != '0'){
            cnt++;
            Queue<Integer> temp = new LinkedList<>();
            while(!q.isEmpty()){
                int cur = q.poll();
                int y = cur / 1000;
                int x = cur % 1000;
                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if(visited[ny][nx] != 0) continue;
                    visited[ny][nx] = cnt;
                    if(a[ny][nx] != '0'){
                        a[ny][nx] = '0';
                        temp.add(1000 * ny + nx);
                    } else q.add(1000* ny + nx);
                }
            }
            q = temp;
        }
        System.out.println(visited[y2][x2]);
    }
}