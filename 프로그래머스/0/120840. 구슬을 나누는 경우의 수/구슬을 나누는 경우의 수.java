class Solution {
    public long solution(int balls, int share) {
        long n = Math.min(share, balls - share);
        long temp = n;
        long up = 1;
        long bot = 1;
        for(long i = n; i >= 1; i--){
            up *= balls--;
            bot *= temp--;
            if(up % bot == 0) {
                up /= bot;
                bot /= bot;
            }
        }
        up/=bot;
        return up;
    }
}
/*
nCm
1, 2, 3, 4, 5
1, 2, 

*/