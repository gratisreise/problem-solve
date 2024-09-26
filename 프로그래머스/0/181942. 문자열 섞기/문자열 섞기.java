class Solution {
    public String solution(String str1, String str2) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < str1.length(); i++){
            ret.append(str1.charAt(i));
            ret.append(str2.charAt(i));
        }
        return ret.toString();
    }
}