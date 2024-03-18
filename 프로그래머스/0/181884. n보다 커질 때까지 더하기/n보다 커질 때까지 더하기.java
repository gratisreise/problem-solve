class Solution {
    public int solution(int[] numbers, int n) {
        int ret = 0;
        for(int i : numbers){
            ret += i;
            if(ret > n) break;
        }
        
        return ret;
    }
}