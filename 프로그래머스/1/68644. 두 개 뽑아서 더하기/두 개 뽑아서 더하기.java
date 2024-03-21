import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1 ; j < numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                if(l.contains(sum)) continue;
                l.add(sum);
            }
        }
        Collections.sort(l);
        return l;
    }
}