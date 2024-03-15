class Solution {
    public String solution(String rny_string) {
        String ret = "";
        for(int i = 0; i < rny_string.length(); i++){
            if(rny_string.charAt(i) == 'm'){
                ret += "rn";
            } else ret += rny_string.charAt(i);
        }
        return ret;
    }
    
}