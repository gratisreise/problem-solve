class Solution {
    public int[] solution(int[] array) {
        int[] ret = {0, 0};
        int mx = -1;
        int mx_index = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] > mx){ 
                mx = array[i];
                mx_index = i;
            }
        }
        ret[0] = mx;
        ret[1] = mx_index;
        return ret;
    }
}