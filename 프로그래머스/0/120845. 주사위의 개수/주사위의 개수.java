class Solution {
    public int solution(int[] box, int n) {
        int ret = 1;
        for(int i : box){
            ret *= (i / n);
        }
        
        return ret;
    }
}