import java.io.*;
import java.util.*;

public class Main{
    static int n, k, l, y, x, ret, idx, dir = 1;
    static int[][] a, visited;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static Deque<Pair> dq = new ArrayDeque<>();
    static List<Pair> conv = new ArrayList<>();
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
        //
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        a = new int[n + 4][n + 4];
        visited = new int[n + 4][n + 4];

        //사과위치 입력
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            a[y][x] = 1;
        }

        l = Integer.parseInt(br.readLine());

        /*
        * 방향변환 횟수
        * conv에 ( , 방향)
        * 3은 뭐지?
         */
        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if(c == 'D') conv.add(new Pair(t, 1));
            else conv.add(new Pair(t, 3));
        }

        dq.add(new Pair(0, 0));
        while(!dq.isEmpty()){
            ret++;
            Pair p = dq.peek();
            y = p.f;
            x = p.s;
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            // 충돌하면 게임종료
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1){
                break;
            }
            /**
             * 좌표의 값이 0이면
             * 꼬리가 늘어나지 않으므로 마지막
             *
             */
            if(a[ny][nx] == 0){
                Pair tail = dq.pollLast();
                // 뱀의 몸이 있는 자리없애기
                visited[tail.f][tail.s] = 0;
            } else { //방향변환이 없으면
                a[ny][nx] = 0; // 좌표의
            }

            visited[ny][nx] = 1;
            dq.addFirst(new Pair(ny, nx));

            if(idx < l && ret == conv.get(idx).f){
                dir = (dir + conv.get(idx).s) % 4;
                idx++;
            }
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}