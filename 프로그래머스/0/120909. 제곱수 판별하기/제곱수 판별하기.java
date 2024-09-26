class Solution {
    public int solution(int n) {
        for(int i = 1; i * i <= n; i++){
            if(i * i == n) return 1;
        }
        return 2;
    }
}