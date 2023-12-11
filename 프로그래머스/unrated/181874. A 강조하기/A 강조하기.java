class Solution {
    public String solution(String myString) {
        String temp = myString.toLowerCase();
        String ret = "";
        for(char c : temp.toCharArray()){
            if(c == 'a') ret += (char)(c - 32);
            else ret += c;
        }
        return ret;
    }
}