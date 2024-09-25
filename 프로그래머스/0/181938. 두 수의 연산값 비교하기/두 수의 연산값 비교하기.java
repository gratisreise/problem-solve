class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int num1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int num2 = 2 * a * b;
        return num1 > num2 ? num1 : num2;
    }
}