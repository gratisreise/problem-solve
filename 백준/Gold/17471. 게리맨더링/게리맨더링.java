import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int) 1e9;
    static int n, m, temp, ret = INF;
    static int[] comp, a, visited;
    static List<Integer>[] adj;

    static Pair dfs(int now, int team) {
        visited[now] = 1;
        // 인원수
        Pair ret = new Pair(1, a[now]);
        for (int next : adj[now]) {
            // 방문함 거르기
            if (visited[next] != 0) continue;
            // 다른팀 거르기
            if (comp[next] != team) continue;
            Pair temp = dfs(next, team);
            ret.first += temp.first;
            ret.second += temp.second;
        }
        return ret;
    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n + 4];
        adj = new ArrayList[n + 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            while (m-- > 0) {
                temp = Integer.parseInt(st.nextToken());
                adj[temp].add(i);
                adj[i].add(temp);
            }
        }

        // 1 ~ 2^n-2 까지 경우의 수
        for (int i = 1; i < (1 << n) - 1; i++) {
            comp = new int[n + 4];
            visited = new int[n + 4];
            // 1팀, 2팀
            int idx1 = -1, idx2 = -1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    comp[j + 1] = 1;
                    idx1 = j + 1;
                } else idx2 = j + 1;
            }
            // first : 방문한 구역, second : 인구수
            Pair temp1 = dfs(idx1, 1);
            Pair temp2 = dfs(idx2, 0);

            // 공평하게 나뉘었으면
            if (temp1.first + temp2.first == n) {
                //최소가 되는 차이값
                ret = Math.min(ret, Math.abs(temp1.second - temp2.second));
            }
        }

        ret = (ret == INF ? -1 : ret);
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}