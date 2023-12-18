class Solution {
    public String solution(String my_string) {
        String answer = "";
        int[] cnt = new int[150];
        for(char c : my_string.toCharArray()){
            if(cnt[(int)c] != 0) continue;
            cnt[(int)c] += 1;
            answer += c;
        }
        return answer;
    }
}