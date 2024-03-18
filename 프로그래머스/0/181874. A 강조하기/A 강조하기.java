class Solution {
    public String solution(String myString) {
        String ret = "";
        for(char c : myString.toCharArray()){
            if(c == 'a') ret += (char)(c - 32);
            else if(c < 97 && c != 'A' && c != ' '){
                ret += (char)(c + 32);
            } else ret += c;
        }
        
        return ret;
    }
}