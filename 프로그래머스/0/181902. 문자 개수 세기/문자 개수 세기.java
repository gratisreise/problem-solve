class Solution {
    public int[] solution(String my_string) {
        int[] ret = new int[52];
        for(char c : my_string.toCharArray()){
            if(Character.isLowerCase(c)) ret[c - 'a' + 26] += 1;
            else ret[c - 'A'] += 1;
        }
        return ret;
    }
}