class Solution {
    public String solution(String rsp) {
        String ret = "";
        
        for(char c : rsp.toCharArray()){
            if(c == '2') ret += '0';
            else if(c == '0') ret += '5';
            else if(c == '5') ret += '2';
        }
        
        return ret;
    }
}
//