class Solution {
    private boolean check(int n){
        int cnt = 0;
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0) {
                if(i * i == n) cnt++;
                else cnt += 2;
            }
        }
        return cnt >= 3;
    }
    public int solution(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++) if(check(i)) ret++;
        return ret;
    }
}