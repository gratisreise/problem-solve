import java.util.*;
class Solution {
    static List<Integer> ret = new ArrayList<>();
    static Set<Integer> temp = new HashSet<>();
    public List<Integer> solution(int[] num) {
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < i; j++){
                temp.add(num[i] + num[j]);
            }
        }
        for(int i : temp) ret.add(i);
        Collections.sort(ret);
        return ret;   
    }
}