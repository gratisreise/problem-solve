import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> l = new ArrayList<>();
        for(int i : arr){
            if(i >= 50 && i % 2 == 0){
                l.add(i / 2);
            } else if(i <= 50 &&  i % 2 != 0){
                l.add(i * 2);
            } else {
                l.add(i);
            }
        }
        return l;
    }
}