class Solution {
    public int solution(int[][] dots) {
        int n = 10000;
        int m = -1;
        for(int i = 1; i < dots.length; i++){
            if(dots[0][0] != dots[i][0] && dots[0][1] != dots[i][1]) continue;
            n = Math.min(Math.abs(dots[0][0] - dots[i][0]) + Math.abs(dots[0][1] - dots[i][1]), n);
            m = Math.max(Math.abs(dots[0][0] - dots[i][0]) + Math.abs(dots[0][1] - dots[i][1]), m);
        }
        return n * m;
    }
}