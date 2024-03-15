class Solution {
    public int solution(int[] numbers, int n) {
        int ret = 0;
        for(int i : numbers){
            if(ret > n) break;
            ret += i;
        }
        
        return ret;
    }
}