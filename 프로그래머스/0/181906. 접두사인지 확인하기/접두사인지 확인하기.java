class Solution {
    public int solution(String my_string, String is_prefix) {
        int ret = 0;
        String temp = "";
        if(my_string.length() > is_prefix.length()){
        for(int i = 0; i < is_prefix.length(); i++){
            temp += my_string.charAt(i);
        }
            }
        if(temp.equals(is_prefix)) ret = 1;
        return ret;
    }
}