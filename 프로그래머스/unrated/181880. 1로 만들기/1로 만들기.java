class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i = 0; i < num_list.length; i++){
            int n = num_list[i];
            while(n != 1){
                if(n % 2 == 0) n /= 2;
                else n = (n - 1) / 2;
                answer++;
            }
        }
        return answer;
    }
}