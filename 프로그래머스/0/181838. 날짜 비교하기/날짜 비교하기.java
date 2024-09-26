class Solution {
    public int solution(int[] date1, int[] date2) {
        int answer = 0;
        if(date1[0] < date2[0]) return 1;
        else if(date1[0] == date2[0] && date1[1] < date2[1]) return 1;
        else if(date1[0] == date2[0] && date1[1] == date2[1] && date1[2] < date2[2]) return 1;
        return answer;
    }
}