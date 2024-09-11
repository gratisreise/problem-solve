import java.util.*;
class Solution {
    //방향
    static int[] dy = {1, 0, -1};
    static int[] dx = {0, 1, -1};
    //2차원배열
    static int[][] temp;
    public List<Integer> solution(int n) {
        temp = new int[n + 1][n + 1];
        move(0, n, 1, 0, 0);
        List<Integer> ret = new ArrayList<>();
        for(int[] arr : temp){
            for(int a : arr){
                if(a == 0) continue;
                ret.add(a);
            }
        }
        return ret;
    }
    private void move(int d, int n, int startNum, int y, int x){
        if(n == 0) return;
        int cy = y;
        int cx = x;
        int number = startNum;
        for(int i = 0; i < n; i++){
            int ny = cy + dy[d % 3];
            int nx = cx + dx[d % 3];
            temp[cy][cx] = number;
            number++;
            if(i == n - 1) break;
            cy = ny;
            cx = nx;
        }
        // 방향 더하기, 크기 -1, 숫자는 더한거 그대로 가지고 하기, 시작점 방향 바꾼거 더하기
        move(d + 1, n - 1, number, cy + dy[(d + 1) % 3], cx + dx[(d+1) % 3]);
    }
}
/*
1.더하는 값은 고정, 방향과 크기는 변화
*/