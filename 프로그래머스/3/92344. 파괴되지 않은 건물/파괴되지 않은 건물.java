import java.util.*;
class Solution {
    private int pow(int num){
        int ans = 1;
        while(num-- > 0){
            ans*= -1;
        }
        return ans;
    }
    private void go(int[][] ret, int[] arr){
        int type = arr[0];
        int r1 = arr[1], c1 = arr[2];
        int r2 = arr[3], c2 = arr[4];
        int deg = arr[5];
        ret[r1][c1] += pow(type) * deg;
        ret[r1][c2 + 1] += -1 *pow(type) * deg;
        ret[r2+1][c1] += -1 * pow(type) * deg;
        ret[r2 +1][c2 + 1] += pow(type) * deg;    
    }
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] ret = new int[n+1][m+1];
        int len = skill.length;
        //차이지정
        for(int i = 0; i < len; i++){
            go(ret, skill[i]);
        }
        
        //가로 누적합: 이전합 + 현재값
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= m; j++){
                ret[i][j] = ret[i][j-1] + ret[i][j];
            }
        }
        
        //세로 누적합: 
        for(int i = 0; i  < m; i++){
            for(int j = 1; j <= n; j++){
                ret[j][i] = ret[j-1][i] + ret[j][i];
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ret[i][j] = ret[i][j] + board[i][j];
                if(ret[i][j] > 0) cnt++;
            }
        }
        
        return cnt;
    }
}
/*
n*m, 
공격받으면 내구도 감소, 
적: 공격하여 파괴, 내구도 0이하 파괴,
아군: 회복으로 내구도 높임,
직사각형 모양으로 공격 및 회복,
(행, 열)
0이하도 계속 하락하게 된다, 
보드: 1000 * 1000 = 백만
내구도: 1000이하, 
skill: 공격, 회복, 25만, 1:공격, 2: 회복, 
강도: 1~500
100만 * 25만 => 2500억
[질문]
시간 복잡도를 어떻게 줄이지?
공간상에서의 
아이디어: 누적합 + 차이배열( )
각각의 
*/