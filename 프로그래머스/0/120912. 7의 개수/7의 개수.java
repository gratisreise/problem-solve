class Solution {
    
    public int solution(int[] array) {
        int answer = 0;
        for(int i : array){
            for(char c : String.valueOf(i).toCharArray()){
                if(c == '7') answer++;
            }
        }
        return answer;
    }
}