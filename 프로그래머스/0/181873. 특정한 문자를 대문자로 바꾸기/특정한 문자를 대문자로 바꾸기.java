class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder ret = new StringBuilder();
        for(char c : my_string.toCharArray()){
            if(String.valueOf(c).equals(alp)) ret.append(Character.toUpperCase(c));
            else ret.append(c);
        }
        return ret.toString();
    }
}