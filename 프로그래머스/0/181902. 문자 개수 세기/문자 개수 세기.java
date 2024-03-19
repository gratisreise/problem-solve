class Solution {
    public int[] solution(String my_string) {
        int[] ret = new int[52];
        for(char c : my_string.toCharArray()){
            if('A' <= c && c <= 'Z'){
                ret[c - 'A']++;
            } else if('a' <= c && c <= 'z'){
                ret[c - 'a' + 26]++;
            }
        }
        return ret;
    }
}