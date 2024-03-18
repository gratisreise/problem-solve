class Solution {
    public String solution(String my_string) {
        String ret = "";
        for(char c : my_string.toCharArray()){
            if(c >= 97) ret += (char)(c - 32);
            else ret += (char)(c + 32);
        }
        return ret;
    }
}