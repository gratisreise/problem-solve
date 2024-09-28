import java.util.*;
class Solution {
    public int solution(int[] numbers, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i : numbers) q.add(i);
        while(--k > 0){
            q.add(q.poll());
            q.add(q.poll());
        }
        return q.peek();
    }
}