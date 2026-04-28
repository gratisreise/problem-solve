import java.util.*;
class Solution {
    private Map<Long, Long> mp = new HashMap<>();
    private long findEmpty(long cur){
        if(!mp.containsKey(cur)){
            mp.put(cur, cur + 1);
            return cur;
        }
        
        long nextEmpty = findEmpty(mp.get(cur));
        mp.put(cur, nextEmpty);
        return nextEmpty;
    }
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] ret = new long[n];
        var mp = new HashMap<Long, Long>();
        
        for(int i = 0; i < n; i++){
            ret[i] = findEmpty(room_number[i]);
        }
        
        return ret;
    }
}
/*
조건
- 1 ~ k번 구분 k개 방
- 처음 모든방 비어있음, 
- 한번에 한명씩 신청순으로 방 배정
- 고객은 투숙 원하는 방 번호 제출
- 원하는 방 있으면 즉시 배정
- 없으면 원하는 방보다 큰놈중 가장 작은 놈 배정
- k는 1조 이하 자연수, 
- 20만, 

아이디어
20만의 크기 
각각의 경우마다 찾아주는 경우로하면?
1이20만 => 1 + 2 + .... 20 = 20만 * 20만 - 1
그럼 이분 탐색으로 가능한가? 가장
해당 숫자에 대해 큰놈중 가장작은 놈은 없나?? 
그럼 모든 숫자 1조개의 숫자에서 모든 오큰수는 불가능할듯
나보다 큰수를 logn번으로 찾을 수 있다면??
아 이거를 이분탐색에서 조건처리 하면 안되나??
log 1조 * 20만
1조 자체의 처리에서 숫자보다 큰놈이면 전부 위로 올라가게 하기
숫자를 넣으면 바로 나보다 크거나 같은 놈들주 최소인 노들 못찾나??

자료구조
결과배열, 저장set

로직
1. 20만을 돌면서 하나씩 방배정 해주면서 결과 배열 만들기
2. 결과배열 반환

*/