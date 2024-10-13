import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.add(i);
        int ret = 0;
        while(pq.peek() < K){
            ret++;
            if(pq.size() == 1) return -1;
            int a = pq.poll();
            int b = pq.poll();
            pq.add((a + b*2));
        }
        return ret;
    }
}