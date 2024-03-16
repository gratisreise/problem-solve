class Solution {
    public int solution(int[] array, int height) {
        int ret = 0;
        for(int i : array){
            if(i > height) ret++;
        }
        return ret;
    }
}