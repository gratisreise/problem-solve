import java.util.*;
class Solution {
    private static final int[][][] cases = {
        {{0, 1}, {2, 3}},
        {{0, 2}, {1, 3}},
        {{0, 3}, {1, 2}}
    };
    public int solution(int[][] dots) {
        int answer = 0;
        for(int i = 0; i < 3; i++){
            double inclination = 0;
            double prev = 0;
            for(int j = 0; j < 2; j++){
                int dy = dots[cases[i][j][0]][0] - dots[cases[i][j][1]][0];
                int dx = dots[cases[i][j][0]][1] - dots[cases[i][j][1]][1];
                inclination = (double) dy / dx;
                if(prev == inclination) return 1;
                prev = inclination;
            }
        }
        return 0;
    }
}
/*
두팀씩 짝 짓는 경우의 수를 구하여 저장
해당 경우의 수를 돌면서 기울기 체크
{{0, 1}, {2, 3}}
{{0, 2}, {1, 3}}
{{0, 3}, {1, 2}}
겹친다? => 모든 점의 
y = 2x + 1;
{1, 3},{2, 5}, {3, 7}, {4, 9}

*/