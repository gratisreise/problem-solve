class Solution {
    public int fact(int n){
        int ret = 1;
        for(int i = 1; i <= n; i++){
            ret *= i ;
        }
        return ret;
    }
    public int solution(int n) {
        int answer = 0;
        for(int i = 0; i <= n; i++){
            if(fact(i) > n) break;
            answer = i;
        }
        return answer;
    }
}