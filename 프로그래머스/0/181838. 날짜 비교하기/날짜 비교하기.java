class Solution {
    public int solution(int[] date1, int[] date2) {
        int ret = 0;
        if(date1[0] < date2[0]) ret = 1;
        else if(date1[0] == date2[0]){
            if(date1[1] < date2[1]) ret = 1;
            else if(date1[1] == date2[1]){
                if(date1[2] < date2[2]) ret = 1;
            }
        }
        return ret;
    }
}