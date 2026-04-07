class Solution {
    static int k, n;
    static int[] stones;
    private boolean check(int mid){
        int[] temp = stones.clone();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            temp[i] -= mid;
            if(temp[i] < 0) cnt++;
            else if(temp[i] >= 0) {
                cnt = 0;
            }
            if(cnt >= k) return false;
        }
        if(cnt >= k) return false;
        return true;
    }
    public int solution(int[] s, int kk) {
        stones = s; k = kk; n = s.length;
        int l = 1, r = 200000000;
        int ret = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(check(mid)){
                l = mid + 1;
                ret = mid;
                
            } else {
                r = mid - 1;
            }
        }
        return ret;
    }
}
/*
징검다리 건너기
1. 디딤돌 밟으면 -1
2. 디딤돌 0 밟기 불가, 건너뛰기 해야함
3. 가장 가까운 디딤돌부터 밟기
한친구가 모두 건넌다음 징검다리 건너기
최대 건너뛰기 가능한 칸 k
최대 몇명까지 가능한지 
친구의 수는 무제한, 
배열 원소는 2억, 배열크기는 20만
결정문제인가?? 친구들의 수는 무제한이라 불가??
한다해도 저 20만 * 친구 숫자(10만이 넘으면??)
dp인가?? 특정 상황에 따라 조건이 바뀌지 않는다
전반적인 갯수의 상태를 알아야 가능할 것 같다
20만 * 무제한???? => 터짐
20만 * 2억
1이상 stones길이 이하의 자연수?? =>
1인데 1칸 뛰어넘기 가능이면 무한대?? 아님. 가장 가까운 디딤돌부터 밟아야함
dp?? 뭘로 상태를 정의할건데??
완탐은 불가능한데;;;

2억명이네 가능하다 이분탐색 
1 ~ 2억 이분탐색 정하고 
2억명 보내면서 확인하면 될
k처리를 어떻게 하지?? => 한명씩 보내는게 아니라 
한번에 다빼고 칸수가 k개 이상 비는게 있으면 컷

*/