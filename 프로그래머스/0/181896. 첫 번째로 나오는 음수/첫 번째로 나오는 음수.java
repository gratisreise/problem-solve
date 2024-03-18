class Solution {
    public int solution(int[] num_list) {
        int ret = -1;
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] < 0){
                ret = i;
                break;
            }
        }
        
        return ret;
    }
}