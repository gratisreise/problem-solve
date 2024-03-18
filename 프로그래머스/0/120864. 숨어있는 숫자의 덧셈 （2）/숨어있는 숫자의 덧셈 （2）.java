class Solution {
    public int solution(String my_string) {
        int ret = 0;
        String temp = "";
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if('0' <= c && c <= '9'){
                temp += c;
            } else if(c > 65 && temp.length() > 0){
                ret += Integer.parseInt(temp);
                temp = "";
            }
        }
        if(temp.length() > 0) ret += Integer.parseInt(temp);
        
        
        return ret;
    }
}