class Solution {
    public int solution(int number, int n, int m) {
        int ret = 0;
        if(number % n == 0 && number % m == 0) ret = 1;
        
        return ret;
    }
}