class Solution {
    public String solution(String my_string, String letter) {
        String ret = "";
        for(int i = 0; i < my_string.length(); i++){
            if((my_string.charAt(i) + "").equals(letter)) continue;
            ret += my_string.charAt(i);
        }
        return ret;
    }
}