import java.util.*;
class Solution {
    public List<Integer> solution(int[] emergency) {
        List<Integer> l = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        for(int i : emergency) l.add(i);
        Collections.sort(l, (a, b) -> b - a);
        for(int i  : emergency) ret.add(l.indexOf(i) + 1);
        return ret;
    }
}