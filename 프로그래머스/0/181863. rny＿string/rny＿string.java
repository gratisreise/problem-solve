class Solution {
    public String solution(String rny_string) {
        String ret = "";
        for(char c : rny_string.toCharArray()){
            if(c == 'm') ret += "rn";
            else ret += c;
        }
        
        return ret;
    }
}