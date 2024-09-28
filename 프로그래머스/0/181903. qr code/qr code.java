class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < code.length(); i++){
            if(i % q == r) ret.append(code.charAt(i));
        }
        return ret.toString();
    }
}