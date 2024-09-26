class Solution {
    public int solution(int a, int d, boolean[] included) {
        int ret = 0;
        for(int i = 0; i < included.length; i++){
            if(included[i]) ret += (a + i*d);
        }
        return ret;
    }
}