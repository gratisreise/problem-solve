import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static List<Integer> dfs = new ArrayList<>();
    static List<Integer> bfs = new ArrayList<>();

    static boolean[] visited;

    static void dfs(int now){
        visited[now] = true;
        dfs.add(now);
        for(int next : graph[now]){
            if(visited[next]) continue;
            dfs(next);
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            bfs.add(now);
            for(int next : graph[now]){
                if(visited[next]) continue;
                visited[next] = true;
                q.offer(next);
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
        visited = new boolean[n+1];

        for(int i=  1; i <= n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 1; i <= n; i++) graph[i].sort(Comparator.naturalOrder());

        dfs(v);
        Arrays.fill(visited, false);
        bfs(v);

        var ret = new StringBuilder();
        for(int i = 0; i < dfs.size(); i++){
            ret.append(dfs.get(i));
            if(i != dfs.size() - 1) ret.append(" ");
        }
        ret.append("\n");
        for(int i = 0; i < bfs.size(); i++){
            ret.append(bfs.get(i));
            if(i != bfs.size() - 1) ret.append(" ");
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}
/*
정점번호가 낮은 순으로 순회
node[1, N], N[1, 1000], M[1, 1만]
v:시작
출력: dfs -> bfs

각 탐색에서 buffer로append하기
각 탐색에서 넘길때 append하고 넘기기 now에서 계속 append하고 넘기기



*/