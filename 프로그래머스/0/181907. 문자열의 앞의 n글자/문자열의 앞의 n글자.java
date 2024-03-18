class Solution {
    public String solution(String my_string, int n) {
        String ret = "";
        for(int i = 0; i < n; i++){
            ret += my_string.charAt(i);
        }
        return ret;
    }
}