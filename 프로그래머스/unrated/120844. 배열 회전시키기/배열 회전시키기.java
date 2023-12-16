import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers, String direction) {
        List<Integer> ret = new ArrayList<>();
        if(direction.equals("right")){
            ret.add(numbers[numbers.length - 1]);
            for(int i = 0; i < numbers.length - 1; i++){
                ret.add(numbers[i]);
            }
        } else {
            for(int i = 1; i < numbers.length; i++){
                ret.add(numbers[i]);
            }
            ret.add(numbers[0]);
        }
        return ret;
    }
}