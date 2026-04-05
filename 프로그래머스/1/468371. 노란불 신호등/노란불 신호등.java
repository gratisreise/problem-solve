import java.util.*;
class Solution {
    static int[] jugi;
    static int lcm(int[] arr){
        int gob = 1;
        for(int i : arr) gob *= i;
        return gob;
    }
    static int solve(int lcm, int[][] signals){
        int n = signals.length;
        for(int i = 1; i <= lcm; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                int sum = signals[j][0] + signals[j][1] + signals[j][2];
                int start = signals[j][0] + 1;
                int end = signals[j][0] + signals[j][1];
                if(i % sum >= start && i % sum <= end) cnt++;
            }
            if(cnt == n) return i;
        }
        return -1;
    }
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;
        jugi = new int [n];
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < 3; j++) sum += signals[i][j];
            jugi[i] = sum;
        }
        
        int lcm = lcm(jugi);
        return solve(lcm, signals);
    }
}

/*
초록 -> 노랑 -> 빨강 반복
1초부터 시작, 초록불부터 시작, 
정전: 모두 노란불
n 모든 신호등이 노랑 색이 되는 가장 빠른 시각(초), 존재x -1 리턴
2 <= n <= 5,
각 신호등이 노랑불이 될 시간은 정해져 있다 주기성을 가짐
첫 노랑불 => 빨 + 초 + 노 = 20 이니깐 20 초 안에 주기가 
이거 구간인데 어떻게 구하지??
노랑색 구간의 겹침이 발생
노랑색 구간이 될 수 있는 시간의 범위 
1 2 3 4 5 6 7
n = 1 : 3 4 5 + 7 
n = 2 : 10 11 12
나머지가 g보다 크고 
노랑의 범위는 첫 범위 + 주기 
첫 범위는 어떻게 구하지?? 
각 주기의 최소 공배수 만큼 넘어갔을 때 공통되는 노랑 범위가 없으면 -1
이주기들이 할 수 있는 모든 조합을 다 했는데도 안된 거니깐
주기 배열, 최소공배수, 메서드
1. 각 주기의 주기를 구한다
2. 각 주기의 최소 공배수 만큼 시간을 증가 시키면서 노랑불 들어오는지 체크
3. 되면 해당 시간 리턴
4. 아니면 그냥 -1 리턴
*/