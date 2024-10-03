import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < lines.length; i++){
            for(int j = lines[i][0]; j < lines[i][1]; j++){
                cnt.put(j, cnt.getOrDefault(j, 0) + 1);
            }
        }
        for(int i : cnt.keySet()) if(cnt.get(i) >= 2) answer++;
        return answer;
    }
}