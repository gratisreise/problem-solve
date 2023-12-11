class Solution {
    public int solution(String number) {
        int answer = 0;
        int n = 0;
        for(char c : number.toCharArray()){
            n += c - '0';
        }
        answer = n % 9;
        return answer;
    }
}