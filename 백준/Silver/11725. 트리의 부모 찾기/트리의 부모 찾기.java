import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        List<Integer>[] tree = new List[n+1];

        for(int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            var st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        var q = new LinkedList<Integer>();
        var vis = new int[n+1];
        vis[1] = 1;
        q.offer(1);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : tree[now]){
                if(vis[next] > 0) continue;
                vis[next] = now;
                q.offer(next);
            }
        }

        var ret = new StringBuilder();
        for(int i = 2; i <= n; i++){
            ret.append(vis[i]).append("\n");
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}