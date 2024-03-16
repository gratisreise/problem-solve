class Solution {
    public int solution(int n) {
        int ret = 0;
        for(int i = 0; i <= n; i += 2){
            ret += i;
        }
        return ret;
    }
}