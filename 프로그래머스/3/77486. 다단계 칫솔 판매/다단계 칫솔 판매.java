import java.util.*;

class Solution {
    static int n;
    static int[] ret;
    static Map<String, String> graph = new HashMap<>();
    static Map<String, Integer> idxMap = new HashMap<>();
    static void go(String name, int price){
        if(price == 0) return;
        int idx = idxMap.get(name);
        int next = price / 10;
        if(next < 1){
            ret[idx] += price;
            return;
        }
        ret[idx] += price - next;
        if(!graph.containsKey(name)) return;
        go(graph.get(name), next);
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        n = enroll.length;
        ret = new int[n];
        for(int i = 0; i < n; i++){
            idxMap.put(enroll[i], i);
            if(referral[i].equals("-")) continue;
            graph.put(enroll[i], referral[i]);
            
        }
        
        int m = seller.length;
        for(int i = 0; i < m; i++){
            int price = amount[i] * 100;
            String start = seller[i];
            go(seller[i], price);
        }
        
        return ret;
    }
}
/*
System.out.println();
판매하면 해당 노드 포함 자식으로 분배, 
각자 얼마나 벌었는가 궁금, 
각자 판거에 10%를 부모에게 지급 
가장 밑에서부터 위로 이익이 분배됨
소수점 밑은 버린다, 1원 미만의 경우 분배x
1개당 100원
로직
1만, 
이름 -> 추천인
이름 돌면서 각자 이익분배
각자 결과 배열에 넣기
1. referall을  돌면서 새로운  이름 -> 추천인 Map에 노드 형태로 저장 
2. enroll을 돌면서 깊이 우선 탐색으로 이익을 분배한다
 2-1. 이익은 리프에 도달할때까지 10%를감소(0원이면 종료)
3. 결과배열을 반환한다.


*/