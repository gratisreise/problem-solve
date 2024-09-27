class Solution {
    private int count(int num, int k){
        int cnt = 0;
        for(char c : String.valueOf(num).toCharArray()){
            if(c- '0' == k) cnt++;
        }
        return cnt;
    }
    public int solution(int i, int j, int k) {
        int ret = 0;
        for(int num = i; num <= j; num++){
            ret += count(num, k);
        }
        return ret;
    }
}