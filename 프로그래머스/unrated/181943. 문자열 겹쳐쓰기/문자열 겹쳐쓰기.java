class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String ret = "";
        ret += my_string.substring(0, s);
        ret += overwrite_string;
        ret += my_string.substring(s + overwrite_string.length(), my_string.length());
        return ret;
    }
}