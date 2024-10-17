import java.util.*;
class Solution {
    private boolean isValid(int d, int[] rocks, int n){
        int removed = 0;
        int last = 0;
        for(int rock : rocks){
            if(rock - last < d){
                removed++;
                continue;
            }
            last = rock;
        }
        return removed <= n;
    }
    public int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        int start = 1;
        int end = distance + 1;
        Arrays.sort(rocks);
        while(end - start > 1){
            int d = (start + end) / 2;
            // d 조건 검사 후 범위 좁히기
            if(isValid(d, rocks, n)){
                start = d;
            } else {
                end = d;
            }
        }
        return start;
    }
}
/*
출발 - 도착 사이 바위 중 몇개 제거
지점 사이의 거리의 최솟값의 최댓값
바위 n개를 이용하여 특정 거리 d에 대해 
모든 지점 사이의 거리가 d 이상이 되는 d 중 가장 큰 값을 구하여라.
1. 바위 위치를 앞에서부터 순서대로 순회한다
2. 인접한 바위 사이의 거리를 구하면서 거리가 d보다 작으면 바위 하나를 없앤다
3. 모두 반복했을 때 없앤 바위 개수가 n보다 같거나 작으면 d는 조건을 만족한다.
[1, distance + 1)
*/