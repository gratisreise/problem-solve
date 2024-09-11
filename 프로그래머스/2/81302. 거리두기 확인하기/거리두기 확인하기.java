import java.util.*;
class Solution {
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean check;
    static char[][] temp;
    public List<Integer> solution(String[][] places) {
        List<Integer> ret = new ArrayList<>();
        for(String[] sArr : places){
            int row = sArr.length;
            int col = sArr[0].length();
            temp = new char[row][col];
            
            for(int i = 0; i < row; i++){
                temp[i] = sArr[i].toCharArray();
            }
            
            //--------
            
            // 초기화 
            check = false;
            visited = new int[row][col];
            
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(temp[i][j] == 'P') {
                        go(i, j, 2, row, col);
                    }
                    if(check) break;
                }
            }
            if(check) ret.add(0);
            else ret.add(1);
            
        }    
        return ret;
    }
    private void go(int y, int x, int cnt, int n, int m){
        if(cnt == 0) return;
        if(check) return;
        //방문처리
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 경계값 처리
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx] != 0) continue;
            // 파티션 있으면 더이상 못간다
            if(temp[ny][nx] == 'X') continue;
            // 범위 안에 사람 있으면 true
            if(temp[ny][nx] == 'P') check = true;
            go(ny, nx, cnt - 1, n, m);
        }
        visited[y][x] = 0;
    }
    
}

/*
- 대기실 5개, 5*5 크기
- 맨해튼 거리(|y1-y2| + |x1-x2|) > 2
- 파티션 있으면 허용
크기2의 dfs 탐색을 할 동안 
*/