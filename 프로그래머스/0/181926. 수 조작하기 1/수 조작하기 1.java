class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for(char c : control.toCharArray()){
            answer += switch(c){
                    case 'w' -> 1;
                    case 's' -> -1;
                    case 'd' -> 10;
                    case 'a' -> -10;
                    default -> 0;
            };
        }
        return answer;
    }
}