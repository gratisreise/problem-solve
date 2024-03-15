class Solution {
    public String solution(String cipher, int code) {
        String ret = "";
        for(int i = 0; i < cipher.length(); i++){
            if((i + 1) % code == 0) ret += cipher.charAt(i);
        }
        return ret;
    }
}