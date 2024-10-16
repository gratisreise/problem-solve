class Solution {
    private boolean isValid(long t, int n, int[] times){
        long c = 0;
        for(int time : times){
            c += t / time;
        }
        return c >= n;
    }
    
    public long solution(int n, int[] times) {
        long start = 1;
        long end = 100000000000000L;
        while(end > start){
            long t = (start + end) / 2;
            
            if(isValid(t, n, times)){
                end = t;
            } else {
                start = t + 1;
            }
        }
        
        return start;
    }
}
/*
가능한 최대의 시간에서 최소의 시간을 찾는다
최소의 조건은 뭐지?

*/