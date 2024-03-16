class Solution {
    public int solution(int n) {
        int ret = 2;
        for(int i = 0; i < n/2; i++){
            if(n == i * i) ret = 1;
        }
        return ret;
    }
}