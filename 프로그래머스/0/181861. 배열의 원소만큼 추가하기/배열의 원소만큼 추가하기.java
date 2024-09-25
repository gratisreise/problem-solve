import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> l = new ArrayList<>();
        for(int i : arr){
            for(int j = 0; j < i; j++){
                l.add(i);
            }
        }
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}