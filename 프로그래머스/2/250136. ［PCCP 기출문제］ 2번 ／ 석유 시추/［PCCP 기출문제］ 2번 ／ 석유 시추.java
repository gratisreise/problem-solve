import java.util.*;
class Solution {
    static int n, m;
    static boolean[][] visited;
    static int[][] land;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] ret;
    static List<Integer> ll = new ArrayList<>();
    private void go(int y, int x){
        visited[y][x] = true;
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        List<int[]> q1 = new ArrayList<>();
        while(!q.isEmpty()){
            int[] arr = q.poll();
            q1.add(arr);
            int cy = arr[0], cx = arr[1];
            cnt++;
            for(int d = 0; d < 4; d++){
                int ny = cy + dy[d], nx = cx + dx[d];
                if(ny < 0|| nx < 0 || ny >= n || nx >= m) continue;
                if(land[ny][nx] == 0 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }
        
        ll.add(cnt);
        for(int[] arr : q1){
            ret[arr[0]][arr[1]] =  ll.size() - 1;
        }
    }
    private void clear(boolean[][] arr){
        for(boolean[] temp : arr){
            Arrays.fill(temp, false);
        }
    }
    public int solution(int[][] l) {
        n = l.length;
        m = l[0].length;
        land = l;
        visited = new boolean[n][m];
        ret = new int[n][m];
        for(int[] arr : ret){
            Arrays.fill(arr, -1);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || l[i][j] == 0) continue;
                go(i, j);
            }
        }
        int ans = -1;
        for(int j = 0; j < m; j++){
            Set<Integer> st = new HashSet<>();
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(ret[i][j] == -1 || st.contains(ret[i][j])) continue;
                st.add(ret[i][j]);
                sum += ll.get(ret[i][j]);
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*
행:n, 열:m,
수직으로 단 하나만 뚫기 가능,
가장 많은 석유 뽑기, 행으로 뚫기 불가능,
석유의 일부를 지나면 전부 뽑기 가능,
한번 돌려서 크기를 정하고 그 크기만큼 채운다음에 
아이디어: 열로 내려가면서 dfs 체크후 크기합하고 리턴하기
1. 열마다 행 아래로 내려가면서 dfs로 크기 구하기
2. 석유량을 대소 비교
3. 결과 반환
*/