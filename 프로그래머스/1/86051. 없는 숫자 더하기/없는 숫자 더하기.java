class Solution {
    public int solution(int[] numbers) {
        int ret = 0;
        int[] cnt = new int[10];
        for(int i : numbers) cnt[i]++;
        for(int i = 0; i < 10; i++){
            if(cnt[i] == 0) ret += i;
        }
        
        return ret;
    }
}