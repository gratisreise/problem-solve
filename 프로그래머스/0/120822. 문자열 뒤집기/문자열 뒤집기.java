class Solution {
    public String solution(String my_string) {
        String ret = "";
        for(int i = my_string.length() - 1; i >= 0; i--){
            ret += my_string.charAt(i);
        }
        return ret;
    }
}