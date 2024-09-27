class Solution {
    private int facto(int n){
        int fac = 1;
        for(int i = 1; i <= n; i++) fac *= i;
        return fac;
    }
    public int solution(int n) {
        int ret = 1;
        while(true){
            int temp = facto(ret);
            if(temp > n) break;
            ret++;
        }
        return ret-1;
    }
}