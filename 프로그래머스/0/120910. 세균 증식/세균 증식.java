class Solution {
    public int solution(int n, int t) {
        int ret = n;
        for(int i = 0; i < t; i++){
            ret *= 2;
        }
        return ret;
    }
}