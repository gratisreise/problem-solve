class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        String temp = "";
        int start = my_string.length() - is_suffix.length();
        if(start >= 0){
        for(int i = start; i < my_string.length(); i++){
            temp += my_string.charAt(i);
        }
            }
        if(temp.equals(is_suffix)) answer = 1;
        return answer;
    }
}