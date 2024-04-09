import java.util.*;
class Solution {
    static int[] a = new int[10000004];
    public int solution(int k, int[] tangerine) {
        int ret = 0;
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < tangerine.length; i++){
            int n = tangerine[i];
            a[n]++;
            if(!num.contains(n)) num.add(n); //num에 없는 숫자면 넣어주기
        }
        
        Collections.sort(num, (a1, a2) -> a[a2] - a[a1]); //빈도순대로 정렬
        for(int i : num){ //돌면서 빈도순대로 k의 숫자에서 빼주기
            k -= a[i];
            ret ++;
            if(k <= 0) break;
        }
        
        return ret;
    }
}