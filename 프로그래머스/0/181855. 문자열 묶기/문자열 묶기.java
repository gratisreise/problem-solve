import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        for(String s : strArr){
            mp.put(s.length(), mp.getOrDefault(s.length(),0) + 1);
        }
        for(int i : mp.values()) ret.add(i);
        Collections.sort(ret, (a, b) -> Integer.compare(b, a));
        return ret.get(0);
    }
}
/*
맵 -> 길이: 갯수
리스트 -> 길이
정렬 -> 갯수내림차, 길이내림차
*/