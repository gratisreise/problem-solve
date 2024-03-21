class Solution {
    public int solution(int[] a, int[] b) {
        int ret = 0;
        for(int i = 0; i < a.length; i++){
            ret += a[i] * b[i];
        }
        return ret;
    }
}