class Solution {
    static int nanugiNum(int n){
        int temp = n;
        int ret = 0;
        while(temp != 1){
            if(temp % 2 == 0) temp /= 2;
            else {
                temp -= 1;
                temp /= 2;
            }
            ret++;
        }
        return ret;
    }
    public int solution(int[] num_list) {
        int ret = 0;
        for(int i : num_list){
            ret += nanugiNum(i);
        }
        return ret;
    }
}