class Solution {
    public int solution(int a, int b) {
        int ret = 0;
        String temp = "" + a + b;
        int temp1 = 0;
        int temp2 = 0;
        temp1 = Integer.parseInt(temp);
        temp2 = 2 * a * b;
        ret = temp1 > temp2 ? temp1 : temp2;
        return ret;
    }
}