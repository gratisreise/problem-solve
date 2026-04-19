class Solution {
    private boolean check(int[] diffs, int[] times, long limit, int mid){
        long sum = 0;
        int n = diffs.length;
        long prev = 0;
        for(int i = 0; i < n; i++){
            int diff = diffs[i];
            int time = times[i];
            int cnt = Math.max(diff - mid, 0);
            sum += cnt*(prev + time) + time;
            prev = time;
            if(sum > limit) return false; 
        }
        return sum <= limit;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int l = 1, r = 100_000;
        while(l <= r){
            int mid = (l + r) / 2;
            if(check(diffs, times, limit, mid)){
                answer = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return answer;
    }
}
/*
n개 퍼즐 시간내
난이도, 소요시간, 
숙련도-> 퍼즐 틀리는 횟수 바뀜
[문풀]
1. 숙련도 이하 문제: 틀리지 않고 소요시간 사용하여 해결
2. 숙련도 초과 문제: 난이도-숙련도번 틀림, prev 사용해서 이전 문제 풀고 다시 현재풀기(난이도 무관)
틀리는 횟수 = Maht.max(난이도 - 레벨, 0)
제한시간 limit, 숙련도의 쵯솟값 구하기
모든 숫자는 자연수
아이디어: 이분탐색 => 숙련도의 결정문제, 숙련도의 최대, 최소에서 결정하기 
1관 10만 사이에서 구하기, 한 지점 이기 때문에 <=로 조건 사용
복잡도: 30만 * log10만  => 가능
자료구조: 
1. 최소1 최대 10만 사이의 숙련도를 이분탐색한다
2. 가능 한 숙련도인지 체크
    2-1. 배열을 돌면서 시간 계산
    2-2. 계산결과가 limit 이하면 통과 
    2-3. 아니면 불합
2. 해당 값이 숙련도에 가능하면 숙련도를 낮춘다
3. 아니면 숙련도를 높인다 


*/