class Solution {
    public double solution(int[] arr) {
        double ret = 0;
        for(int i : arr){
            ret += i;
        }
        ret /= (double)arr.length;
        
        return ret;
    }
}