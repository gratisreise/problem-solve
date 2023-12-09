import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] ret = new int[num_list.length - 5];
        Arrays.sort(num_list);
        for(int i = 5; i < num_list.length; i++){
            ret[i - 5] = num_list[i];
        }
        return ret;
    }
}