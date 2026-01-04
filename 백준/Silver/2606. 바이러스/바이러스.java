import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int dfs(int now){
        visited[now] = true;
        int ret = 1;
        for(int next : graph[now]){
            if(visited[next]) continue;
            ret += dfs(next);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        graph = new List[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            var st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        out.println(dfs(1)-1);

        out.flush();
        out.close();
    }
}