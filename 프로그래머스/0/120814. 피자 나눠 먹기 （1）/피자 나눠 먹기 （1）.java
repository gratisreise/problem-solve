class Solution {
    public int solution(int n) {
        int ret = 0;
        ret = n / 7;
        if(n % 7 > 0) ret++;
        return ret;
    }
}