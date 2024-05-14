import java.io.*;
import java.util.*;

public class Main{
    static int[][] _a = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 1, 9},
            {3, 9, 1},
            {1, 3, 9},
            {1, 9, 3}
    };
    static int n;
    static int[][][] visited = new int[65][65][65];
    static int[] hp = new int[3];
    static class Pair{
        int a, b, c;
        Pair(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            hp[i] =  Integer.parseInt(st.nextToken());
        }
        Queue<Pair> q = new LinkedList<>();
        visited[hp[0]][hp[1]][hp[2]] = 1;
        q.add(new Pair(hp[0], hp[1], hp[2]));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int a = p.a;
            int b = p.b;
            int c = p.c;
            if(visited[0][0][0] != 0) break;
            for(int i = 0; i < 6; i++){
                int na = Math.max(0, a - _a[i][0]);
                int nb = Math.max(0, b - _a[i][1]);
                int nc = Math.max(0, c - _a[i][2]);
                if(visited[na][nb][nc] != 0) continue;
                visited[na][nb][nc] = visited[a][b][c] + 1;
                q.add(new Pair(na, nb, nc));
            }
        }
        bw.write(String.valueOf(visited[0][0][0]-1)+'\n');
        bw.flush();
    }
}
/*
1. 공격에 따라 깍이는 hp를 배열로
2. 경우에 따라 방문배열 채워주기
 */