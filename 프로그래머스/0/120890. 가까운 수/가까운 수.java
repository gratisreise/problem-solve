import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            int cha = Math.abs(array[i] - n);
            l.add(i);
            mp.put(i, cha);
        }
        Collections.sort(l, (a, b)->{
            if(mp.get(a) == mp.get(b)){
                return Integer.compare(array[a], array[b]);
            } return Integer.compare(mp.get(a), mp.get(b));
        });
        return array[l.get(0)];
    }
}
/*
mp에 인덱스별 차이값저장
mp에 저장된 차이값이 작은 순으로 저장
만약 차이값이 같으면 인덱스가 작은 값?
*/