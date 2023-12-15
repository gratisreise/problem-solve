class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = num_list[answer.length - 1 - i];
        }
        return answer;
    }
}