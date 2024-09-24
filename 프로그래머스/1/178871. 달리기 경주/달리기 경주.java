import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> mp1 = new HashMap<>(); // 이름 - 등수
        Map<Integer, String> mp2 = new HashMap<>(); // 등수 - 이름
        for(int i = 0; i < players.length; i++) {
                mp1.put(players[i], i + 1);
                mp2.put(i + 1, players[i]);
        };
        
        for(String s : callings){
            int idx = mp1.get(s);
            String temp = mp2.get(idx - 1);
            mp1.put(s, idx - 1); // 추월한놈 빼주기
            mp1.put(temp, idx); // 당한놈 그자리 대체
            mp2.put(idx - 1, s); // 추월한 놈 등수 빼주기
            mp2.put(idx, temp);
        }
        
        for(int i = 0; i < answer.length; i++) answer[i] = mp2.get(i + 1);
    
        return answer;
    }
}
/*
1등~ 현재등수 players
부른 이름 callings

*/