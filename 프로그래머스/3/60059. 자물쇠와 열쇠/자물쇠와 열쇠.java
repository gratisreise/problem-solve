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
[문제명: 자물쇠와 열쇠 (2020 카카오 공채)]

1. 관찰 및 제약 조건
- N(자물쇠), M(열쇠) 크기 최대 20.
- 시간 복잡도 계산: 회전(4) * 이동(약 2N * 2N) * 체크(N * N)
  => 4 * 400 * 400 = 640,000 연산 (1초 제한 대비 매우 여유로움).
- 핵심: 열쇠를 회전시키고, 자물쇠의 범위를 벗어나더라도 모든 위치에서 맞춰봐야 함.
- 성공 조건: 자물쇠의 모든 홈(0)을 열쇠의 돌기(1)로 채워야 하며, 돌기끼리 충돌(2)해서는 안 됨.

2. 전략 및 복잡도
- 알고리즘: 완전 탐색 (Brute-force) + 시뮬레이션.
- 시간 복잡도: O(K * N^2) (K는 상수, 약 64만).
- 전략: 
    1) 자물쇠를 중앙에 둔 3배 크기의 확장 배열(bigLock)을 생성.
    2) 열쇠를 90도씩 4번 회전시키며 반복.
    3) 각 회전마다 확장 배열 위에서 열쇠를 한 칸씩 이동(슬라이딩).
    4) 열쇠를 더한 후 자물쇠 영역(중앙)이 모두 1인지 확인하고, 아니면 열쇠를 다시 빼줌(복구).

3. 자료구조
- int[][] bigLock: 인덱스 계산을 단순화하기 위한 3N * 3N 크기의 확장 배열.
- int[][] rotatedKey: 90도 회전시킨 열쇠를 저장할 배열.
- 방향 벡터는 불필요 (단순 2중 for문 이동으로 해결).

4. 로직 (Step-by-Step)
- Step 1: 90도 회전 함수 구현 -> rotated[j][m - 1 - i] = original[i][j]
- Step 2: 3배 크기 bigLock 생성 후 중앙(N ~ 2N-1 영역)에 원래 lock 복사.
- Step 3: 4번의 회전 루프 실행:
    - 0부터 2N 미만까지 y, x 좌표를 이동하며 addKey 실행.
    - check 함수로 중앙 영역이 전부 1인지 확인.
    - 맞다면 즉시 return true.
    - 틀리다면 removeKey로 원상복구 후 다음 이동.
- Step 4: 모든 경우를 다 해봤는데 안 되면 return false.

5. 예외 상황 및 Edge Case
- 자물쇠가 이미 모두 1인 경우: 처음부터 check가 true가 되어야 함.
- 열쇠의 돌기와 자물쇠의 돌기가 만나는 경우: bigLock의 값이 2가 되므로 check에서 false 처리.
- 열쇠가 자물쇠 밖으로 나가는 경우: 확장 배열 덕분에 인덱스 에러 없이 자연스럽게 처리됨.
*/