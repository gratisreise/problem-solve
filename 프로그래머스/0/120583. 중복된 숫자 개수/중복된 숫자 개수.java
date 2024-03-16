class Solution {
    public int solution(int[] array, int n) {
        int ret = 0;
        for(int i : array){
            if(i == n) ret++;
        }
        return ret;
    }
}