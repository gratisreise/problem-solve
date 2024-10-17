import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Set<Integer> st = new HashSet<>();
        for(int v : numbers) st.add(v);
        int sum = 0;
        for(int i = 0; i <= 9; i++){
            if(!st.contains(i)) sum += i;
        }
        return sum;
    }
}