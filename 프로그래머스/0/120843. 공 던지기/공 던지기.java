import java.util.*;
class Solution {
    public int solution(int[] numbers, int k) {
        int ret = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i : numbers) q.add(i);
        for(int i = 0; i < k; i++){
            ret = q.peek();
            q.add(q.poll());
            q.add(q.poll());
        }
        return ret;
    }
}