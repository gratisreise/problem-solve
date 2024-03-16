import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers, int num1, int num2) {
        List<Integer> ret = new ArrayList<>();
        for(int i = num1; i <= num2; i++){
            ret.add(numbers[i]);
        }
        return ret;
    }
}