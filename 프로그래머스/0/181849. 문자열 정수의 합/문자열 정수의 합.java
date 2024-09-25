class Solution {
    public int solution(String num_str) {
        int ret = 0;
        for(char c : num_str.toCharArray()) ret += c - '0';
        return ret;
    }
}