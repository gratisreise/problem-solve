class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        for(int i : index_list){
            answer += my_string.charAt(i);
        }
        return answer;
    }
}
//my_string 과 정수 배열 index_list