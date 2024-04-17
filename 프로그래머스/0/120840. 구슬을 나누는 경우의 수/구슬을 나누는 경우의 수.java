class Solution {
    public long solution(int balls, int share) {
        long answer = 1;
        long mid = 1;
        share = Math.min(share, balls - share);
        for(long i = balls, j = share; i > balls - share && j > 0; i--, j--){
            System.out.println(i + " :: "+ j);
            answer *= i;
            if(answer % j == 0) answer /= j;
            else mid *= j;
        }
        answer /= mid;
        return answer;
    }
}