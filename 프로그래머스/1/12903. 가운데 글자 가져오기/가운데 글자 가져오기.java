class Solution {
    public String solution(String s) {
        String ret = "";
        int n = s.length()/2;
        if(s.length() % 2 == 0){
            ret = s.substring(n - 1, n + 1);
        } else {
            ret = s.substring(n, n + 1);
        }
        return ret;
    }
}