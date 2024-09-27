class Solution {
    private int count(int n){
        int cnt = 0;
        while(n != 1){
            n /= 2;
            cnt++;
        }
        return cnt;
    }
    public int solution(int[] num_list) {
        int ret = 0;
        for(int i : num_list) ret += count(i);
        return ret;
    }
}