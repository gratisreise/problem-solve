class Solution {
    public int solution(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                ret += i + (n / i);
            }
        }
        return ret / 2;
    }
}