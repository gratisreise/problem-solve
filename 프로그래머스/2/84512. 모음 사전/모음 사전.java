import java.util.*;

class Solution {

    static List<String> l = new ArrayList<>();
    static int cnt = -1;
    static int r = 5;
    static boolean flag = false;
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
        if(flag) return;
        cnt++;
        if(combine(dq).equals(word)) flag = true;
        if(dq.size() == r) return;
        for(int i = 0; i < r; i++){
            dq.addLast(strs[i]);
            solve(word, dq);
            dq.removeLast();
        }
    }
    public int solution(String word) {
        solve(word, new ArrayDeque<>());
        return cnt;
    }
}