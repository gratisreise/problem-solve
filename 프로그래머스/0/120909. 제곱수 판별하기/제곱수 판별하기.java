class Solution {
    public int solution(int n) {
        int ret = 2;
            
        for(int i = 1; i <= n; i++){
            if(i * i == n) ret = 1;
        }
        
        return ret;
    }
}