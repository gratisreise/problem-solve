class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String s = num+"";
        for(int j = 0, i = 0; i < s.length(); i++){
            j++;
            if(s.charAt(i) - '0' == k){
                answer = j;
                break;
            }
        }
        return answer;
    }
}