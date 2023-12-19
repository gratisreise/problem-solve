class Solution {
    public String solution(String my_string, int m, int c) {
        String ret= "";
        for(int i = c -1 ; i < my_string.length(); i += m){
            ret += my_string.charAt(i);
        }
        return ret;
    }
}