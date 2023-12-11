class Solution {
    public String solution(String n_str) {
        String ret = "";
        boolean flag = false;
        for(char c : n_str.toCharArray()){
            if(c != '0') flag = true;
            if(flag) ret += c;
        }
        return ret;
    }
}