import java.util.*;
import java.util.stream.*;
class Solution {
    private void count(int index, Set<String> banned, String[][] bans,
                    Set<Set<String>> banSet){
        if(index == bans.length){
            banSet.add(new HashSet<>(banned));
            return;
        }
        
        for(String id : bans[index]){
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id); //원복
        }
    }
    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                                .filter(id -> id.matches(banned))
                                .toArray(String[]::new))
                .toArray(String[][]::new);
        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }
}
/*
상태
(index, banned)
종료조건
(index, banned) -{banned} index == 끝인 경우 or {} == 매칭할 수 있는 사용자 아이디가 없는 경우
*/