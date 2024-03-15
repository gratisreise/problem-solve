class Solution {
    public String solution(String rsp) {
        String ret = "";
        for(int i = 0; i < rsp.length(); i++){
            if(rsp.charAt(i) == '2') ret += "0";
            else if(rsp.charAt(i) == '0') ret += "5";
            else if(rsp.charAt(i) == '5') ret += "2";
        }
        return ret;
    }
}