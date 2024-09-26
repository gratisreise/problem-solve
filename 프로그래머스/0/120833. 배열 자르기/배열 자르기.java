class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] ret = new int[num2 - num1 + 1];
        for(int i = 0, temp = num1; i < num2 - num1 + 1; i++){
            ret[i] = numbers[temp++];
        }
        return ret;
    }
}