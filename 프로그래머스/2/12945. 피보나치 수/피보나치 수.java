class Solution {
    public int solution(int n) {
        int[] ret = new int[100001];
        ret[0] = 0; ret[1] = 1;
        for(int i = 2; i <= n; i++){
            ret[i] = (ret[i - 1] + ret[i - 2])% 1234567;
        }
        
        return ret[n];
    }
}
/*
f(n) = f(n - 1) + f(n - 2);



*/