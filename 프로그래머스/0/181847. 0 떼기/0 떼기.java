class Solution {
    public String solution(String n_str) {
        StringBuilder ret = new StringBuilder(n_str);
        while(ret.charAt(0) == '0') ret.deleteCharAt(0);
        return ret.toString();
    }
}