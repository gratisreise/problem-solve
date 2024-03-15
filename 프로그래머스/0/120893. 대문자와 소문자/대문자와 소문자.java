class Solution {
    public String solution(String my_string) {
        String ret = "";
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c >= 97){
                ret += (char)(c - 32);
            } else {
                ret += (char)(c + 32);
            }
        }
        return ret;
    }
}