class Solution {
    public int solution(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++){
            int check = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0) check++;
                if(check == 3) break;
            }
            if(check == 3) ret++;
        }
        
        return ret;
    }
}