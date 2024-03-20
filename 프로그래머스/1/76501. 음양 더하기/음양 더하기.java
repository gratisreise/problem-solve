class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int ret = 0;
        for(int i = 0; i < signs.length; i++){
            if(signs[i]) ret += absolutes[i];
            else ret -= absolutes[i];
        }
        return ret;
    }
}