class Solution {
    public String solution(String my_string, int n) {
        String ret = "";
        for(char c : my_string.toCharArray()){
            for(int i = 0; i < n; i++){
                ret += c;
            }
        }
        return ret;
    }
}