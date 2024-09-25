class Solution {
    public int solution(int[] num_list) {
        int num1 = 1;
        int num2 = 0;
        for(int i : num_list){
            num1 *= i;
            num2 += i;
        }
        return num1 < (int)Math.pow(num2, 2) ? 1 : 0;
    }
}