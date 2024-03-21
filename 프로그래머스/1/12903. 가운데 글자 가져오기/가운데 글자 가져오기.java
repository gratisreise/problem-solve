class Solution {
    public String solution(String s) {
        String ret = "";
        int size = s.length();
        
        if(size % 2 == 0){
            size /= 2;
            ret = s.substring(size - 1, size + 1);
        } else {
            size /= 2;
            ret = s.substring(size, size + 1);
        }
        return ret;
    }
}