import java.util.*;
class Solution {
    private void hanoi(int n, int from, int to, List<int[]> process){
        if(n == 1){
            process.add(new int[]{from, to});
            return;
        }
        
        int empty = 6 - from - to;
        
        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
}
/*
아이디어: 한 개씩 줄여가면서 부분문제로 나눠지나?
1. 상태
- 옮기려는 원판의 개수 n
- 원판이 현재 위치한 기둥 from
- 원판이 이동해야 하는 기둥 to
(n from, to) = 원판 n개를 기둥 from에서 기둥 to로 옮기는 과정

2. 종료조건
(1, from, to) = [[from, to]]
가장 큰 상태와 가장 작은 상태를 이용하여 점화식 유추
원판 n개를 이동시키는 부분 문제는 원반 n-1개를 이동시키는 부분 문제로 해결할 수 있다.
empty = 6 - from - to -> 빈 나무기둥 찾기
- (n - 1, from, to)
- (1, from, to)
- (n - 1, empty, to)

3. 점화식
(n, from, to) = (n - 1, from, empty) + (1, from, to) + (n - 1, empty, to)
단 empty = 6 - from - to

*/