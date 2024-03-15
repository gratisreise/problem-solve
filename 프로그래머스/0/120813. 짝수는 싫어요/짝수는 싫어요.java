import java.util.*;
class Solution {
    public List<Integer> solution(int n) {
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n; i += 2){
            l.add(i);
        }
        return l;
    }
}