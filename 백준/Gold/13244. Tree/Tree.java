import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m, a, b, cnt;
    static boolean[] visited;
    static List<Integer>[] adj;
    // 깊이 우선 탐색(DFS) 메서드
    static void dfs(int here) {
        visited[here] = true;
        for (int there : adj[here]) {
            if (!visited[there]) {
                dfs(there);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader와 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        t = Integer.parseInt(br.readLine());

        // 테스트 케이스마다 실행
        while (t-- > 0) {
            // n과 m 입력
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            // 그래프 초기화
            adj = new ArrayList[n + 4];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            visited = new boolean[n + 4];
            cnt = 0;
            // 간선 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                //양방향
                adj[a].add(b);
                adj[b].add(a);
            }
            // DFS를 통해 연결 요소 개수 세기
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            // 트리인지 그래프인지 판별
            if (m == n - 1 && cnt == 1) bw.write("tree\n");
            else bw.write("graph\n");
        }

        // 출력 flush
        bw.flush();
        bw.close();
        br.close();
    }
}