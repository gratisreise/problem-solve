class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        String s = "";
        if(my_string.length() > is_prefix.length()){
        for(int i = 0; i < is_prefix.length(); i++){
            s += my_string.charAt(i);
        }
            }
        if(s.equals(is_prefix)) answer = 1;
        return answer;
    }
}