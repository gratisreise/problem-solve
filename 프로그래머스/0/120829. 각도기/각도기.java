class Solution {
    public int solution(int angle) {
        int ret = 0;
        if(angle < 90) ret = 1;
        else if(angle == 90) ret =  2;
        else if(angle < 180) ret =  3;
        else if(angle == 180) ret =  4;
        return ret;
    }
}