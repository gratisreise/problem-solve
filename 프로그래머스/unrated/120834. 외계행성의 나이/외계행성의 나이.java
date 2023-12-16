class Solution {
    public String solution(int age) {
        String answer = "";
        String s = age + "";
        for(int i = 0; i < s.length(); i++){
            answer += (char)(s.charAt(i) - '0' + 'a');
        }
        return answer;
    }
}