class Solution {
    public int[] solution(int[] num_list) {
        int[] ret = {0, 0};
        for(int i : num_list){
            if(i % 2 == 0) ret[0]++;
            else ret[1]++;
        }
        return ret;
    }
}