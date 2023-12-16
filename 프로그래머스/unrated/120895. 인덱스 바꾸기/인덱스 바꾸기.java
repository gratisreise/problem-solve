class Solution {
    public String solution(String my_string, int num1, int num2) {
        String ret = "";
        for(int i = 0; i < my_string.length(); i++){
            if(i == num1){
                ret += my_string.charAt(num2);
            } else if(i == num2){
                ret += my_string.charAt(num1);
            } else {
                ret += my_string.charAt(i);
            }
        }
        return ret;
    }
}