class Solution {
    public String solution(String s, int n) {
        String ret = "";
        for(char c : s.toCharArray()){
            if(c == ' '){
                ret += " ";
            } else {
                if('a' <= c && c <= 'z'){
                    if(c + n > 'z') ret += (char)(c + n - 26);
                    else ret += (char)(c + n);
                } else if('A' <= c && c <= 'Z'){
                    if(c + n > 'Z') ret += (char)(c + n - 26);
                    else ret +=(char)(c + n);
                }
            }
        }
        return ret;
    }
}