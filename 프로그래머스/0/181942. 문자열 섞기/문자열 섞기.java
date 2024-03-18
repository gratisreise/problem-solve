class Solution {
    public String solution(String str1, String str2) {
        String ret = "";
        for(int i = 0; i < str1.length(); i++){
            ret += ("" + str1.charAt(i) + str2.charAt(i));
        }
        
        return ret;
    }
}