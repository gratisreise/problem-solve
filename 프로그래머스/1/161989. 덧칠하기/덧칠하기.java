class Solution {
    public int solution(int n, int m, int[] section) {
        int ret = 0;
        int rolled = 0;
        
        for(int i : section){
            if(rolled < i){
                rolled = i + m - 1;
                ret++;
            } 
        }
        return ret;
    }
}