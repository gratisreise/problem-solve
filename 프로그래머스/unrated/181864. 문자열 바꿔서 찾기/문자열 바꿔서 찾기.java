class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String temp = "";
        for(char c : myString.toCharArray()){
            if(c == 'A') temp += 'B';
            else temp += 'A';
        }
        if(temp.contains(pat) == true) answer = 1;
        return answer;
    }
}