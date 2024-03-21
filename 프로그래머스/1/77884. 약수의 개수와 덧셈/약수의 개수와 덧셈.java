class Solution {
    public int solution(int left, int right) {
        int ret = 0;
        for(int i = left; i <= right; i++){
            int n = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0) n++;
            }
            if(n % 2 == 0) ret += i;
            else ret -= i;
        }
        return ret;
    }
}