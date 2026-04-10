import java.util.*;
class Solution {
    static int[][] board;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    private int solve(int[] condi){
        for(int i = 0; i < condi.length;i++){
            condi[i]--;
        }
        int x1= condi[0], y1 = condi[1], x2= condi[2], y2 = condi[3];
        int[][] temp = new int[x2-x1+1][y2-y1+1];
        int x = x1, y = y1, d = 0;
        int nx = x + dx[d], ny = y + dy[d];
        temp[nx-x1][ny-y1] = board[x][y];
        x = nx; y = ny;
        while(x != x1 || y != y1){
            nx = x + dx[d]; ny = y + dy[d];
            if(nx < x1 || ny < y1 || nx > x2 || ny > y2){
                d = (d + 1) % 4;
                nx = x + dx[d]; ny = y + dy[d];
            };
            temp[nx - x1][ny - y1] = board[x][y];
            x = nx; y = ny;
        }
        int ret = 1000 * 1000;
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                int now = temp[i-x1][j-y1];
                if(now == 0) continue;
                ret = Math.min(ret, now);
                board[i][j] = now;
            }
        }
        return ret;
    }
    public List<Integer> solution(int r, int c, int[][] queries) {
        board = new int[r][c];
        int num = 1;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                board[i][j] = num++;
            }
        }
        var ret = new ArrayList<Integer>();
        for(int[] condi : queries){
            ret.add(solve(condi));
        }
        return ret;
    }
}
/*
System.out.println(Arrays.toString(arr));
1~ r*c 숫자 적힘
직사각형 테두리에 있는 숫자를 시계방향으로 한칸씩밀기
회전에 의해 바뀐 숫자들 중 가장 작은 숫자들을 배열에 담아 반환한다

1만번의 회전?? 최대 400만 가능 
회전을 어떻게 표현할까??
1. 크기만큼의 배열을 만든다 
2. 원본배열에서 회전을 하면서 새로운 배열의 직사각형을 채운다
3. 새로운 배열의 직사각형을 돌면서 원본배열의 크기를 채운다 
4. 회전이 끝난후 가장작은 숫자를 반환 한다


*/