class Solution {
    public String solution(String myString) {
        String answer = "";
        for(char c : myString.toCharArray()){
            if(Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            } else answer += c;
        }
        return answer;
    }
}