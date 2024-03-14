class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int mx = -1;
        int index = 0;
        int sum = 0;
        
        for(int i = 0; i < 3; i++){
            if(sides[i] > mx){
                mx = sides[i];
                index = i;
            }
        }
        for(int i = 0; i < 3; i++){
            if(i == index) continue;
            sum += sides[i];
        }
        
        if(sum > mx) answer = 1;
        else answer = 2;
        
        return answer;
    }
}