class Solution {
    public int solution(int[] num_list, int n) {
        int ret = 0;
        
        for(int i : num_list){
            if(i == n) ret = 1;
        }
        return ret;
    }
}