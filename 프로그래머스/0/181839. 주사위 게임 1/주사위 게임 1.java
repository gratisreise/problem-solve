class Solution {
    public int solution(int a, int b) {
        int ret = 0;
        if(a % 2 != 0 && b % 2 != 0) ret = a * a + b * b;
        else if(a % 2 != 0 || b % 2 != 0) ret = 2 * (a +b);
        else ret = Math.abs(a - b);
        return ret;
    }
}