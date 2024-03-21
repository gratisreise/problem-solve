class Solution {
    public String solution(int n) {
        String ret = "";
        for(int i = 1; i <= n; i++){
            if(i % 2 == 0) ret += "박";
            else ret += "수";
        }
        
        return ret;
    }
}