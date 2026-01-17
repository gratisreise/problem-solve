import java.io.*;
import java.util.*;

public class Main {
    static int[] graph, visited;
    static int n, k;
    static boolean check(int now, int cnt){
        if(visited[now] == 1) return false; //순환체크
        if(now == k) return true; //도착지점 도착
        visited[now] = 1;
        if(cnt == 0) return false;
        return check(graph[now], cnt-1);
    };
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n];
        visited = new int[n];
        for(int i = 0; i < n; i++){
            graph[i] = Integer.parseInt(in.readLine());
        }

        int ret = 0;
        while(true){
            ret++;
            Arrays.fill(visited, 0);
            if(check(0, ret)) {
                out.println(ret);
                break;
            }
            if(ret >= n) {
                out.println(-1);
                break;
            }
        }

        out.flush();
        out.close();
    }
}