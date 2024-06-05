import java.io.*;
import java.util.*;

public class Main{
    static int n, k, l, y, x,time, ret, idx, dir = 1;
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
        // 좌표에서 사과의 존재 표시
        a = new int[n + 4][n + 4];
        // 뱀의 길이를 저장
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
        * 시간초 t와 방향변환 c를 입력받는다.
        * conv에 (시간 , 방향)
        * 3은 뭐지?
         */
        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if(c == 'D') conv.add(new Pair(t, 1));
            else conv.add(new Pair(t, 3));
        }

        //뱀 머리의 처음 시간과 방향 입력
        dq.add(new Pair(0, 0));
        visited[0][0] = 1;
        //시간초에 따른 뱀의 움직임 dq에 저장
        while(!dq.isEmpty()){
            time++; //시간
            Pair p = dq.peek();
            y = p.f;
            x = p.s;
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            // 충돌하면 게임종료
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] == 1){
                break;
            }
            /*
            사과 유무에 따른 뱀의 길이처리
             */
            if(a[ny][nx] == 0){
                //이전 꼬리 좌표 없애기
                Pair tail = dq.pollLast();
                visited[tail.f][tail.s] = 0;
            } else a[ny][nx] = 0;

            // 뱀의 길이 처리
            visited[ny][nx] = 1;
            // 뱀의 다음 머리 좌표 저장
            dq.addFirst(new Pair(ny, nx));

            // 변환횟수가 l보다 적고 시간이 변환되어야할 시간과 같으면
            if(idx < l && time == conv.get(idx).f){
                // 방향처리 오른쪽 90도는 +1, 왼쪽 90도는 +3
                dir = (dir + conv.get(idx).s) % 4;
                idx++; // 방향변환 회수 처리
            }
        }
        ret = time; // 결과에 담아주기
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
1. 뱀의 좌표를 저장할 dq
2. 뱀의 몸길이를 체크할 visited
3. 뱀의 방향전환을 저장할 list
4. 사과의 위치 a
5. 게임시간 time
 */