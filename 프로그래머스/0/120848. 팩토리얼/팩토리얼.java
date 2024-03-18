class Solution {
    static int facto(int n){
        int sum = 1;
        for(int i = 1; i <= n; i++){
            sum *= i;
        }
        return sum;
    }
    public int solution(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++){
            if(facto(i) <= n) ret = i;
            else break;
        }
        
        return ret;
    }
}