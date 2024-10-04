import java.util.*;
import java.util.stream.*;
class Solution {
    private void count(int cnt,int idx, char[] arr, Map<String, Integer> mp, StringBuilder sb){
        if(cnt == 0) mp.put(sb.toString(), mp.getOrDefault(sb.toString(), 0) + 1);
        for(int i = idx + 1; i < arr.length; i++){
            sb.append(arr[i]);
            count(cnt - 1, i, arr, mp, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Map<String, Integer> mp = new HashMap<>();
        Map<Integer, List<String>> mp1 = new HashMap<>();
        for(String s : orders){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            for(int i : course){
                if(s.length() < i) break;
                count(i, -1, arr, mp, new StringBuilder());
            }
        }
        List<String> ret = new ArrayList<>();
        for(String s : mp.keySet()){
            if(mp.get(s) < 2) continue;
            if(mp1.containsKey(s.length())) mp1.get(s.length()).add(s);
            else {
                List<String> l = new ArrayList<>();
                l.add(s);
                mp1.put(s.length(), l);
            }
        }
        for(int i : mp1.keySet()){
            Collections.sort(mp1.get(i), (a, b) -> Integer.compare(mp.get(b), mp.get(a)));
        }
        for(int i : mp1.keySet()){
            int max = mp.get(mp1.get(i).get(0));
            for(String s : mp1.get(i)) if(mp.get(s) == max) ret.add(s);
        }
        return ret.stream().sorted().toArray(String[]::new);
    }
}
/*
코스 돌면서 
맵 -> 맵<String, Integer>
각 오더를 돌면서 코스단위롤 쪼개고 맵에 넣기
맵을 돌면서 각코스마다 2개이상인거 다 때려넣기
-> 사전순정렬
*/