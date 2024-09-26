class Solution {
    public int solution(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++){
            if(n % 2 == 0 && i % 2 == 0) ret += i * i;
            else if(n % 2 != 0 && i % 2 != 0) ret += i;
        }
        return ret;
    }
}