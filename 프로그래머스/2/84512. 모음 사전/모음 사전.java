import java.util.*;

class Solution {
    
    static List<String> l = new ArrayList<>();
    static int r = 5;
    static String[] strs = {"A", "E", "I", "O", "U"};
    static String combine(Deque<String> dq){
        if(dq.size() == 0) return "";
        var temp = new StringBuilder();
        for(int i = 0; i < dq.size(); i++){
            temp.append(dq.peekFirst());
            dq.addLast(dq.pollFirst());
        }
        return temp.toString();
    }
    static void solve(String word, Deque<String> dq){
        if(dq.size() == r) return;
        for(int i = 0; i < r; i++){
            dq.addLast(strs[i]);
            l.add(combine(dq));
            solve(word, dq);
            dq.removeLast();
        }
    }
    public int solution(String word) {
        solve(word, new ArrayDeque<>());
        for(int i = 0; i < l.size(); i++){
            if(l.get(i).equals(word)){
                return i+1;
            }
        }
        return -1;
    }
}

/**
길이 5이하
전역 하나 숫자랑 flag 두고
탐색에서 끝나면 멈춰버리기
*/