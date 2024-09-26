class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] ret = new int[start_num - end_num + 1];
        int temp = start_num;
        for(int i = 0; i < start_num - end_num + 1; i++){
            ret[i] = temp--;
        }
        return ret;
    }
}