class Solution {
    public long solution(int cap, int n, int[] deli, int[] pku) {
        long ret = 0;
        int d_storage = 0; // 남은 배달 가능 칸
        int p_storage = 0; // 남은 수거 가능 칸
        
        // 가장 먼 집부터 탐색
        for (int i = n - 1; i >= 0; i--) {
            // 이번 집에서 해야 할 일 누적 (음수가 되면 할 일이 남았다는 뜻)
            d_storage -= deli[i];
            p_storage -= pku[i];

            int cnt = 0;
            // 배달이나 수거 중 하나라도 부족하면 트럭을 보내야 함
            while (d_storage < 0 || p_storage < 0) {
                d_storage += cap;
                p_storage += cap;
                cnt++;
            }
            
            // 트럭을 보냈다면, 현재 위치(i+1)가 이번 여정의 가장 먼 곳임
            if (cnt > 0) {
                ret += (long) (i + 1) * 2 * cnt;
            }
        }
        return ret;
    }
}