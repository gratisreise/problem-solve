class Solution {
    public int solution(int n) {
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int n){
        int[] a = new int[n + 4];
        
        a[0] = 0; a[1] = 1;
        
        for(int i = 2; i <= n; i++){
            a[i] = (a[i - 1] + a[i - 2]) % 1234567;
        }
        return a[n] % 1234567;
    }
    
}