import java.util.*;
class Solution {
    int n, m; 
    private int[][] rotate(int[][] key){
        //90도 오른쪽회전
        int[][] rotated = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int  j = 0; j < m; j++){
                rotated[j][m-1-i] = key[i][j];
            }
        }
        return rotated;
    }
    private void addKey(int[][] bigLock, int[][] key, int y, int x){
        for(int i = y; i < y+m; i++){
            for(int j = x; j < x+m; j++){
                bigLock[i][j] += key[i-y][j-x];
            }
        }
    }
    private void removeKey(int[][] bigLock, int[][] key, int y, int x){
        for(int i = y; i < y+m; i++){
            for(int j = x; j < x+m; j++){
                bigLock[i][j] -= key[i-y][j-x];
            }
        }
    }
    private boolean check(int[][] bigLock){
        for(int i = n; i < n + n; i++){
            for(int j = n; j < n + n; j++){
                if(bigLock[i][j] != 1) return false;
            }
        }
        return true;
    }
    private int[][] initBig(int[][] lock){
        int[][] temp = new int[n*3][n*3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i+n][j+n] = lock[i][j];
            }
        }
        return temp;
    }
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        n = lock.length;
        m = key.length;
        int[][] bigLock = initBig(lock);
        for(int d = 0; d < 4; d++){
            // 체크
            for(int i = 0; i < 2 * n; i++){
                for(int j = 0; j < 2 * n; j++){
                    addKey(bigLock, key, i, j);
                    if(check(bigLock)) return true;
                    removeKey(bigLock, key, i, j);
                }
            }
            print(key);
            key = rotate(key);
            print(key);
        }
        return false;
    }
    private  void print(int[][] arr){
        for(int[] temp : arr){
            System.out.println(Arrays.toString(temp));
        }
    }
}
/*
조건, 제약
자물쇠:N*N 격자, 열쇠: M*M 격자, 푸는방법,
- 열쇠 회전, 이동 가능, 열쇠 돌기 합 자물쇠 홈 => 열림
- 열쇠돌기, 자물쇠돌기 만남x
- 자물쇠의 홈을 빈틈없이 메워야 가능
-  열쇠로 자물쇠 열 수 있으면 true or false
- key: M(3~20), lock(3 ~20)
- M <= N, 0: 홈, 1: 돌기

로직, 복잡도
회전: 4, 이동  4000  , 체크 400
20 * 40 * 0000 => 64만 
복잡도: 64만 <= 10억
자료구조: 임시 2차원배열, 
1. key를 4번 회전, i,j만 큼 이동 시키는 경우 for문돌리기
2. 겹쳐지는 부분 확인하고 빈틈 없으면 return true;

질문 1. 회전은 어떻게 표현해주지?? => 회전은 공식이용 어쩔 수 없다 이건 외우자
질문 2. 이거 겹칩은 어떻게 표현해주지?? 탐색이 평소의 2차원 배열 탐색이랑 다른데 => N을 감싸는 큰형태를 만들어서 체크 하기
회전은 외우자, 확장배열 아이디어 => 겹치는 부분을 확인할때 인덱스 조정보다는 확장하고 체크해주기

*/
