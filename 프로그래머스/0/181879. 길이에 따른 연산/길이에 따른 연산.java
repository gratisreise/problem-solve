class Solution {
    public int solution(int[] num_list) {
        int ret;
        if(num_list.length > 10){
            ret = 0;
            for(int i : num_list) ret += i;
        } else {
            ret = 1;
            for(int i : num_list) ret *= i;
        }
        return ret;
    }
}