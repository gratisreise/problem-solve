class Solution {
    public String solution(String code) {
        String ret = "";
        int mode = 0;
        for(int i = 0; i < code.length(); i++){
            char c = code.charAt(i);
            if(c == '1'){
                if(mode == 0) mode = 1;
                else mode = 0;
            } else {
                if(mode == 0 && i % 2 == 0) ret += c;
                else if(mode == 1 && i % 2 != 0) ret += c;
            }
        }
        if(ret.length() == 0) ret = "EMPTY";
        return ret;
    }
}