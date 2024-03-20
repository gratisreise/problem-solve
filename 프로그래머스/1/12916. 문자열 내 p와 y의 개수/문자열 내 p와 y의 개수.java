class Solution {
    boolean solution(String s) {
        boolean ret = true;
        s = s.toLowerCase();
        int cntp = 0;
        int cnty = 0;
        for(char c : s.toCharArray()){
            if(c == 'p') cntp++;
            else if(c == 'y') cnty++;
        }
        if(cntp != cnty) ret = false;
        
        return ret;
    }
}