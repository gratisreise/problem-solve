import java.io.*;
import java.util.*;

public class Main{
    static int n, k, l, y, x, t, ret, idx, dir = 1;
    static int[][] a, visited;
    static int time;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static Deque<Pair> dq = new ArrayDeque<>();
    static List<Pair> _time = new ArrayList<>();
    static class Pair{
        int f, s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        a = new int[n + 4][n + 4];
        visited = new int[n + 4][n + 4];

        //사과 위치 저장
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            a[y][x] = 1;
        }

        l = Integer.parseInt(br.readLine());
        //방향 전환 저장
        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if(c == 'D') _time.add(new Pair(t, 1));
            else _time.add(new Pair(t, 3));
        }

        dq.add(new Pair(0, 0));
        int time = 0;
        while(!dq.isEmpty()){
            time++;
            Pair p = dq.peek();
            y = p.f;
            x = p.s;
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1){
                break;
            }
            if(a[ny][nx] == 0){
                Pair tail = dq.pollLast();
                visited[tail.f][tail.s] = 0;
            } else a[ny][nx] = 0;

            visited[ny][nx] = 1;
            dq.addFirst(new Pair(ny, nx));

            if(idx < l && time == _time.get(idx).f){
                dir = (dir + _time.get(idx).s) % 4;
                idx++;
            }
        }
        bw.write(String.valueOf(time)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}