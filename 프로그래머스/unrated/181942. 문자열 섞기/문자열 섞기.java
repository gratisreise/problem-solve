class Solution {
    public String solution(String str1, String str2) {
        String ret = "";
        int n = str1.length();
        for(int i = 0; i < n; i++){
            ret += str1.charAt(i);
            ret += str2.charAt(i);
        }
        
        return ret;
    }
}