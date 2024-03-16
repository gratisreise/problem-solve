class Solution {
    public int solution(int a, int b) {
        int ret = 0;
        int num1 = 0;
        int num2 = 0;
        num1 = Integer.parseInt(("" + a + b));
        num2 = 2 * a * b;
        ret = num1 > num2 ? num1 : num2;
        
        
        return ret;
    }
}