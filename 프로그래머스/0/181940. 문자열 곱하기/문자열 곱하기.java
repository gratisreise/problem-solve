class Solution {
    public String solution(String my_string, int k) {
        StringBuilder ret = new StringBuilder();
        while(k-- > 0) ret.append(my_string);
        return ret.toString();
    }
}