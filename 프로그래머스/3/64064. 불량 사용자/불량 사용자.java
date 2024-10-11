import java.util.*;
import java.util.stream.*;

class Solution {
    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet){
        if(index == bans.length){
            banSet.add(new HashSet<>(banned));
            return;
        }
        
        for(String id : bans[index]){
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
            .map(banned -> banned.replace('*', '.'))
            .map(banned -> Arrays.stream(user_id)
                .filter(id -> id.matches(banned))
                .toArray(String[]::new)
            ).toArray(String[][]::new);
        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }
}
/*
상태: (index, banned)
졸료조건:
1) 사용자 아이디로 모든 불량 사용자 아이디를 선택했거나 -> 정상적으로 모든 사용자 아이디 선택
2) 해당 불량 사용자 아이디와 중복되는 사용자 아이디가 있을 때 -> 비정상적인 종료 상황



*/