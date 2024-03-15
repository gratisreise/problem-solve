class Solution {
    public int[] solution(int[] num_list) {
        int[] ret = {0, 0};
        int even = 0;
        int odd = 0;
        for(int i : num_list){
            if(i % 2 == 0) even++;
            else odd++;
        }
        ret[0] = even;
        ret[1] = odd;
        return ret;
    }
}