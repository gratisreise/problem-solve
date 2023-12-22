class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i : array){
            String s = i +"";
            for(char c : s.toCharArray()){
                if(c == '7') answer++;
            }
        }
        return answer;
    }
}