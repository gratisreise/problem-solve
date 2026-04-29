import java.util.*;

class Food implements Comparable<Food> {
    int time;
    int id;

    public Food(int time, int id) {
        this.time = time;
        this.id = id;
    }

    // 시간이 짧은 순으로 정렬 (오름차순)
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 더 먹을 음식이 없음
        long totalTime = 0;
        for (int t : food_times) totalTime += t;
        if (totalTime <= k) return -1;

        // 1. 시간이 짧은 음식부터 빼기 위해 우선순위 큐 사용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long previousTime = 0; // 직전에 다 먹은 음식의 시간
        long remainingFoods = food_times.length; // 남은 음식 개수

        // 2. 가장 짧은 음식부터 하나씩 꺼내며 k에서 소거
        // (현재 음식 시간 - 이전 음식 시간) * 남은 음식 개수 = 이 음식을 다 먹는 데 걸리는 총 시간
        while (!pq.isEmpty()) {
            long currentTime = pq.peek().time;
            long diff = currentTime - previousTime;
            long cost = diff * remainingFoods;

            if (k >= cost) {
                k -= cost;
                previousTime = currentTime;
                pq.poll();
                remainingFoods--;
            } else {
                // 더 이상 한 종류의 음식을 통째로 다 먹을 수 없는 상태
                break;
            }
        }

        // 3. 남은 음식들을 번호(id) 순으로 정렬하여 k초 후의 음식 찾기
        List<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // 번호순 정렬
        result.sort(Comparator.comparingInt(f -> f.id));

        // 남은 k초를 남은 음식 개수로 나눈 나머지가 우리가 먹어야 할 음식의 인덱스
        return result.get((int) (k % remainingFoods)).id;
    }
}