class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String ret = "";
        String suf = "";
        String pre = "";
        int e = overwrite_string.length();
        pre = my_string.substring(0, s);
        suf = my_string.substring(s + e);
        ret = pre + overwrite_string + suf;
        
        
        return ret;
    }
}