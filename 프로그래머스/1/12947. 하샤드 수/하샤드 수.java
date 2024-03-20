class Solution {
    public boolean solution(int x) {
        boolean ret = false;
        String s = "" + x;
        int n = 0;
        for(char c : s.toCharArray()){
            n += (c - '0');
        }
        if(x % n == 0) ret = true;
        
        return ret;
    }
}