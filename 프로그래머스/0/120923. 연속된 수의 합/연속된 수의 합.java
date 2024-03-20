import java.util.*;
class Solution {
    public List<Integer> solution(int num, int total) {
        List<Integer> l = new ArrayList<>();
        for(int i = -1000; i - num <= 1000; i++){
            int sum = 0;
            int n = num;
            int j = i;
            l.clear();
            while(n-- > 0) {
                l.add(j); sum += j++;
            }
            if(sum == total) break;
        }
        return l;
    }
}