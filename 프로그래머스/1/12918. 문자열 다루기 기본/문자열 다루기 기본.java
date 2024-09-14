class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && isNumber(s);
    }
    private boolean isNumber(String s){
        for(char c : s.toCharArray()) if(Character.isAlphabetic(c)) return false;
        return true;
    }
}