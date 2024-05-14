import java.io.*;
import java.util.*;

public class Main{
    static int n, k;
    static int[] visited = new int[200004];
    static int[] cnt = new int[200004];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        

        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        cnt[n] = 1;
        q.add(n);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : new int[]{now + 1, now - 1, now * 2}){
                if(next < 0 || next >= 200004) continue;
                if(visited[next] == 0){
                    visited[next] = visited[now] +1;
                    cnt[next] += cnt[now];
                    q.add(next);
                } else if(visited[next] == visited[now] + 1){
                    cnt[next] += cnt[now];
                }
            }
        }

        bw.write(String.valueOf(visited[k]-1) + '\n');
        bw.write(String.valueOf(cnt[k]) + '\n');
        bw.flush();
    }
}
/*
현재 점 : N, 동생 점 : K
+1, -1, *2로 3가지 경우로 이동
동생을 찾을 수 있는 가장 빠른 시간, 경우의 수
빠른 시간 : visited 방문배열로 구하기
경우의 수 : cnt배열로 각 노드의 경우를 저장하고 더하기
*/