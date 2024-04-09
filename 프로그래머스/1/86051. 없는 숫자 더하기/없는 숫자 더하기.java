class Solution {
    public int solution(int[] numbers) {
        int ret = 0;
        int[] a = new int[10];
        for(int i : numbers) a[i]++;
        for(int i = 0; i < 10; i++) if(a[i] == 0) ret += i;
        
        
        return ret;
    }
}