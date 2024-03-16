import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int end = numbers.length - 1;
        int ret = numbers[end] * numbers[end - 1];
        return ret;
    }
}