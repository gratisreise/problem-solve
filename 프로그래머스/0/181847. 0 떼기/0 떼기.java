class Solution {
    public String solution(String n_str) {
        String ret = "";
        boolean flag = false;
        for(char c : n_str.toCharArray()){
            if(c == '0' && !flag) continue;
            else {
                ret += c;
                flag = true;
            }
        }
        
        return ret;
    }
}