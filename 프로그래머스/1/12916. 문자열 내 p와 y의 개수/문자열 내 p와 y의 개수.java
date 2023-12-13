class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        for(char c : s.toCharArray()){
            if(c == 'p' || c == 'P') p++;
            else if(c == 'y' || c == 'Y') y++;
        }
        if(p == 0 && y == 0) return true;
        if(p == y) answer = true;
        else answer = false;
        return answer;
    }
}