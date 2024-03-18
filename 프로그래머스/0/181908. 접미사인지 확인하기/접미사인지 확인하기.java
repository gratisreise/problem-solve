class Solution {
    public int solution(String my_string, String is_suffix) {
        int ret = 0;
        if(my_string.length() >= is_suffix.length()){
            String temp = "";
            int start = my_string.length() - is_suffix.length();
            for(int i = start; i < my_string.length(); i++){
                temp += my_string.charAt(i);
            }
            if(temp.equals(is_suffix)) ret = 1;
        }
        
        
         return ret;
    }
}