class Solution {
    public int solution(int[] num_list) {
        int ret = 0;
        if(num_list.length >= 11){
            for(int i : num_list){
                ret += i;
            }
        } else {
            ret= 1;
            for(int i : num_list){
                ret *= i;
            }
        }
        return ret;
    }
}