import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int ret = 0;
        
        if(num_list.length > 10){
            for(int i : num_list){
                ret += i;
            }
        } else {
            int temp = 1;
            for(int i : num_list){
                temp *= i;
            }
            ret = temp;
        }
        return ret;
    }
}

//num_list의 길이 11이상 -> 리스트 모든 원소의 합
//num_list의 길이 10이하 -> 모든 원소의 곱