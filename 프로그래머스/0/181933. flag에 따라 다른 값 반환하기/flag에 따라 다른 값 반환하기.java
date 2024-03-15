class Solution {
    public int solution(int a, int b, boolean flag) {
        int ret = 0;
        if(flag) ret = a + b;
        else ret = a - b;
        return ret;
    }
}