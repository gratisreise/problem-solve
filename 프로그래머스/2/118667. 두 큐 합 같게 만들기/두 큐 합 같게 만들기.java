import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long target = 0;
        long sum1 = 0;
        long sum2 = 0;
        int max1 = -1;
        int max2 = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++){
            target += (queue1[i] + queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            max1 = Math.max(queue1[i], max1);
            max2 = Math.max(queue2[i], max2);
        }
        
        if(target % 2 != 0 || max1 > target/2 || max2 > target/2) return -1;
        target /= 2;
        int ret = 0;
        if(sum1 == target) return 0;
        while(sum1 != target){
            if(sum1 > sum2){
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
            } else if(sum2 > sum1){
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
            }
            ret++;
            if(ret > queue1.length * 3) return -1;
        }
        
        return ret;
    }
}

/*
큐의 합을 같게 하는 작업의 최소 횟수
1. 추출 + 추가 = 작업횟수 1로 카우트
2. 모든 큐의 숫자를 더하여 합을 
이분탐색 + 완탐 
1. 총합구하기
2. 우선순위큐에 넣기 오름차순
각 리스트를 오름차순정렬해

*/