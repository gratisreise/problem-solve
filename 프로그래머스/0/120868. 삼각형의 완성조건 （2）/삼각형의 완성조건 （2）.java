class Solution {
    public int solution(int[] sides) {
        int ret = 0;
        int big = Math.max(sides[0], sides[1]);
        int small = Math.min(sides[0], sides[1]);
        int sum = sides[0] + sides[1];
        for(int i = 1; i < big; i++) {
            if(i + small > big) ret++;
        }
        for(int i = big; i < sum; i++){
            if(big + small > i) ret++;
        }
        return ret;
    }
}
/*
1. 둘중 큰게 가장 긴변일 때
2. 가장 긴변이 다른 거일 때
3. 둘중 큰것과 길이가 같을 때
*/