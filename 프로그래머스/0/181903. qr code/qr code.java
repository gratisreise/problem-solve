class Solution {
    public String solution(int q, int r, String code) {
        String ret = "";
        for(int i = 0; i < code.length(); i++){
            if(i % q == r) ret += code.charAt(i);
        }
        
        return ret;
    }
}