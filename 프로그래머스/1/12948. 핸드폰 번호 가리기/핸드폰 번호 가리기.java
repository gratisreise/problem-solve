class Solution {
    public String solution(String phone_number) {
        String ret = "";
        int size = phone_number.length();
        ret = phone_number.substring(size - 4);
        size-=4;
        while(size-- > 0){
            ret = "*" + ret;
        }
        
        return ret;
    }
}