import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] visited;
    static StringBuilder sbd = new StringBuilder();
    static StringBuilder sbb = new StringBuilder();


    static void dfs(int now){
        if(visited[now] == 1) return;
        visited[now] = 1;
        sbd.append(now).append(" ");
        for(int next : graph[now]){
            if(visited[next] == 1) continue;
            dfs(next);
        }
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        sbb.append(start).append(" ");
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph[now]){
                if(visited[next] == 1) continue;
                sbb.append(next).append(" ");
                visited[next] = 1;
                q.add(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        visited = new int[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            graph[i].sort(Comparator.comparingInt(a -> a));
        }

        dfs(v);
        Arrays.fill(visited, 0);
        bfs(v);

        System.out.println(sbd +"\n" + sbb);

        out.flush();
        out.close();
    }
}
/*
dfs, bfs의 탐색결과
정점 번호 낮은 것부터 방문
1 ~ N
n, m, 시작점:v
양방향
그래프 구현
인접리스트
리스트배열 -> 그래프 구현
dfs, bfs 탐색 ㄱㄱ


 */