class Solution {
    public String solution(String my_string, int n) {
        String ret = "";
        for(int i = my_string.length() - n; i < my_string.length(); i++){
            ret += my_string.charAt(i);
        }
        return ret;
    }
}