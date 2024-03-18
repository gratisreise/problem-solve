class Solution {
    public String solution(String myString) {
        String ret = "";
        for(char c : myString.toCharArray()){
            if(c < 'l') ret += 'l';
            else ret += c;
        }
        
        return ret;
    }
}