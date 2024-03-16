class Solution {
    public int solution(int slice, int n) {
        int ret = 0;
        ret =  n / slice;
        if(n % slice > 0) ret++;
        return ret;
    }
}