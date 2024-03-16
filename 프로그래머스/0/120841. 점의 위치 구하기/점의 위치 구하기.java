class Solution {
    public int solution(int[] dot) {
        int x = dot[0];
        int y = dot[1];
        int ret = 0;
        if(x > 0 && y > 0) ret = 1;
        else if(x < 0 && y > 0) ret = 2;
        else if(x < 0 && y < 0) ret = 3;
        else ret = 4;
        return ret;
    }
}