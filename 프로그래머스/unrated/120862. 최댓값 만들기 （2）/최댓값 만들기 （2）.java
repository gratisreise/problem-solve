import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int temp1 = numbers[0] * numbers[1];
        int temp2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        if(temp1 > temp2) answer = temp1;
        else answer = temp2;
        return answer;
    }
}