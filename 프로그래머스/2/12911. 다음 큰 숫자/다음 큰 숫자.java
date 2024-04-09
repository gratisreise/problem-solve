class Solution {
    public int solution(int n) {
        int ret = n;
        int cnt = 0;
        while(n > 0){
            if(n % 2 == 1) cnt++;
            n /= 2;
        }
        while(true){
            ret++;
            int tempb = ret;
            int cntb = 0;
            while(tempb > 0){
                if(tempb % 2 == 1) cntb++;
                tempb /= 2;
            }
            if(cntb == cnt) break;
        }
        return ret;
        
    }
}

//조건1: n의 다음 큰 숫자는 n 보다 크다
//조건2: n의 다음 큰 숫자와 n은 2진수 1의 갯수 같다
//조건3: n의 다음 큰 숫자는 조건 1,2를 만족하는 수중 가장 작은 숫자