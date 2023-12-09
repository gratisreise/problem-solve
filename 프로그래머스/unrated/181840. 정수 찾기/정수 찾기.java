class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for(int i : num_list){
            if(i == n) answer = 1;
        }
        return answer;
    }
}