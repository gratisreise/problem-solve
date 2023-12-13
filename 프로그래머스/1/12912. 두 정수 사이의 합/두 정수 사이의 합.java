class Solution {
    public long solution(long a, long b) {
        long sum = 0;
        if(a > b){
            for(long i = b; i <= a; i++){
                sum += i;
            }
        } else if(b > a){
            for(long i = a; i <= b; i++){
                sum += i;
            }
        } else sum = a;
        
        return sum;
    }
}