class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder ret = new StringBuilder();
        for(char c : my_string.toCharArray()) if(!String.valueOf(c).equals(letter)) ret.append(c);
        return ret.toString();
    }
}