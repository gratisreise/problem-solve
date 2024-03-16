class Solution {
    public String solution(String my_string, String letter) {
        String ret = "";
        String[] temp = my_string.split("");
        for(String s : temp){
            if(s.equals(letter)) continue;
            ret += s;
        }
        return ret;
    }
}