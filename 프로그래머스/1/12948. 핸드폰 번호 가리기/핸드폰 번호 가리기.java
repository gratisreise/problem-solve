class Solution {
    public String solution(String phone_number) {
        String ret = "";
        for(int i = 0; i < phone_number.length() - 4; i++) ret += "*";
        ret += phone_number.substring(phone_number.length() - 4);
        
        
        
        return ret;
    }
}