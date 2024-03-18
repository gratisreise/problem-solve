class Solution {
    public int solution(int a, int b) {
        int ret = 0;
        int temp1 = Integer.parseInt("" + a + b);
        int temp2 = Integer.parseInt("" + b + a);
        if(temp1 > temp2) ret = temp1;
        else ret = temp2;
        return ret;
    }
}