class Solution {
    public int solution(int n) {
        int ret = 1;
        
        for(int i = 1; i <= n / 2; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += j;
                if(sum == n){
                    ret++; break;
                }else if(sum > n) break;
            }
        }
        
        return ret;
    }
}