import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers, int num1, int num2) {
        int start = num1 > num2 ? num2 : num1;
        int end = num1 > num2 ? num1 : num2;
        List<Integer> ret = new ArrayList<>();
        for(int i = start; i <= end; i++){
            ret.add(numbers[i]);
        }
        return ret;
    }
}