class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n % 2 == 0){
            for(int i = 2; i <= n; i += 2){
                answer += i*i;
            }
        } else {
            for(int i = 1; i <= n; i += 2){
                answer += i;
            }
        }
        return answer;
    }
}

//n이 홀수 -> n이하의 홀수인 모든 양의 정수의 합
//n이 짝수 -> n이하의 짝수인 모든 양의 정수의 제곱의 합