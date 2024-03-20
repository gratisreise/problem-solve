class Solution {
    public int solution(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 1){
                ret = i; break;
            }
        }
        return ret;
    }
}