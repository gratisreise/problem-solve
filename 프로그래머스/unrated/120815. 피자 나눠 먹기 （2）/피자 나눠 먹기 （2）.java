class Solution {
    public int solution(int n) {
        int ret = 0;
        
        while(true){
            ret++;
            int temp = 6 * ret;
            if(temp % n == 0) break;
        }
        return ret;
    }
}