class Solution {
    private boolean check(char c){
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
    }
    public String solution(String my_string) {
        StringBuilder ret = new StringBuilder();
        for(char c : my_string.toCharArray()) if(check(c)) ret.append(c);
        return ret.toString();
    }
}