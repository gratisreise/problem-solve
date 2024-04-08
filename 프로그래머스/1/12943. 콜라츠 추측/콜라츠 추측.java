class Solution {
    public int solution(int num) {
        int ret = 0;
        int temp = num;
        if(temp == 1) ret = 0;
        else {
            while(temp != 1){
                if(temp % 2 == 0) temp /= 2;
                else temp = (temp * 3) + 1;                
                ret++;
                if(ret > 480){
                    ret = -1;
                    break;
                }
            }    
        }
        
        return ret;
    }
}