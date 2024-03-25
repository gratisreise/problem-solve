class Solution {
    static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public int solution(int n) {
        int ret = 0;
        
        for(int i = 2; i <= n; i++){
            if(isPrime(i)) ret++;
        }
        
        return ret;
    }
}