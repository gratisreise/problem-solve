class Solution {
    public String solution(String myString) {
        String ret = "";
        myString = myString.toLowerCase();
        for(char c : myString.toCharArray()){
            if(c == 'a'){
                ret += (char)(c - 32);
            } else ret += c;
        }
        return ret;
    }
}