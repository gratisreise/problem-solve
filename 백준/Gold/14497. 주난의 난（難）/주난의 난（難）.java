import java.io.*;
import java.util.*;

public class Main{
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited;
    static char[][] a;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new int[n + 1][m + 1];
        a = new char[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        y--; x--; ey--; ex--;

        for(int i = 0; i < n; i++) a[i] = br.readLine().toCharArray();

        Queue<Integer> q = new LinkedList<>();
        q.add(1000 * y + x);
        visited[y][x] = 1;
        int cnt = 0;

        while(visited[ey][ex] == 0){
            cnt++;
            Queue<Integer> temp = new LinkedList<>();

            while(!q.isEmpty()){
                int cur = q.poll();
                y = cur / 1000;
                x = cur % 1000;
                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if(visited[ny][nx] != 0) continue;
                    visited[ny][nx] = cnt;
                    if(a[ny][nx] != '0'){
                        a[ny][nx] = '0';
                        temp.add(1000 * ny + nx);
                    } else q.add(1000 * ny + nx);
                }
            }
            q = temp;
        }
        bw.write(String.valueOf(visited[ey][ex])+'\n');
        bw.flush();
    }
}