class Solution {
    public int solution(int[] num_list) {
        int ret = 0;
        if(num_list.length >= 11){
            for(int i : num_list) ret += i;
        } else if(num_list.length <= 10){
            ret = 1;
            for(int i : num_list) ret *= i;
        }
        return ret;
    }
}
//num_list길이 11이상 -> 모든원소의 합 || 10이하이면 모든 원소의 곱