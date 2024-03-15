class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(Character c : my_string.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
            answer += (c+"");
        }
        return answer;
    }
}