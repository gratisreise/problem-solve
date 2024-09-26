class Solution {
    public String solution(String my_string, int n) {
        StringBuilder ret = new StringBuilder();
        for(char c : my_string.toCharArray()){
            for(int i = 0; i < n; i++) ret.append(c);
        }
        return ret.toString();
    }
}