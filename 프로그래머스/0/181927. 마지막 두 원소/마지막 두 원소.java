import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] ret = new int[num_list.length + 1];
        for(int i = 0; i < ret.length; i++){
            if(i == ret.length - 1){
                if(ret[i - 1] > ret[i - 2]) ret[i] = ret[i - 1] - ret[i - 2];
                else ret[i] = ret[i - 1] * 2;
            } else ret[i] = num_list[i];
        }
        return ret;
    }
}