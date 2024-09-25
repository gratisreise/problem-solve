class Solution {
    public String solution(String myString) {
        StringBuilder ret = new StringBuilder();
        for(char c : myString.toCharArray()){
            if(c - 'l' < 0) ret.append('l');
            else ret.append(c);
        }
        return ret.toString();
    }
}