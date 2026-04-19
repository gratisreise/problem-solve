import java.util.*;
class Solution {
    static List<int[]> ret = new ArrayList<>();
    static int[] condi = new int[]{10, 20, 30, 40};
    static int n, m;
    static int[][] users;
    static int[] emoticons;
    private int[] calc(List<Integer> l){
        int sum = 0; //이모티콘 판매가격 
        int cnt = 0;//플러스 가입자
        for(int i = 0; i < n; i++){
            int total = 0;
            for(int j = 0; j < m; j++){
                int dis = l.get(j);
                if(dis < users[i][0]) continue;
                int price = emoticons[j];
                total += price * (100 - dis) / 100;
            }
            if(total >= users[i][1]) cnt++;
            else sum += total;
         }
        return new int[]{cnt, sum};
    }
    private void go(int cnt, List<Integer> l){
        if(l.size() == m){
            ret.add(calc(l));
            return;
        }
        for(int i = 0; i < condi.length; i++){
            l.add(condi[i]);
            go(cnt + 1, l);
            l.remove(l.size()-1);
        }
    }
    
    public int[] solution(int[][] u, int[] e) {
        users = u;
        emoticons = e;
        n = users.length;
        m = emoticons.length;
        go(0, new ArrayList<>());
        ret.sort((a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        return ret.get(0);
    }
}
/*
[목표]
1. 이모티콘 플러스 서비스 가입자 수를 최대로 늘릴것 
2. 판매액 최대
우선순위: 1 -> 2
n명의 사용자에게 m개를 할인하여 판매 
할인율 10,20,30,40 중 하나
[서비스 선택 기준]
- 사용자의 기준에 따라 일정 비율 이상 할인 이모티콘 전부 구매 
- 사용자의 기준에 따라 이모티콘 구매비용 일정 이상 => 플러스가입
2만 * 10 => 20만
행사 목적 최대한으로 달성한 결과를 반환 

아이디어: 완탐
자료구조: 경우 저장 리스트, 결과 배열, 할인율 
1. 각 이모티콘 마다 할인율 에따른 경우를 재귀로 표현
2. 끝에 도달 했을 때 경우를 계산하고 결과에 넣기
3. 결과리스트를 정렬하고 첫지점 반환


*/