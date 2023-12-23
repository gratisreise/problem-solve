import java.util.*;
class Solution {
    public int solution(int[] numbers, int k) {
        Queue<Integer> ret = new LinkedList<>();
        k--;
        for(int i : numbers) ret.add(i);
        while(k > 0){
            ret.add(ret.poll());
            ret.add(ret.poll());
            k--;
        }
        int answer = ret.peek();
        return answer;
    }
}