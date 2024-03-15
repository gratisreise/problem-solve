import java.util.*;
class Solution {
    public List<Integer> solution(int start, int end) {
        List<Integer> l = new ArrayList<>();
        for(int i = start; i >= end; i--){
            l.add(i);
        }
        return l;
    }
}