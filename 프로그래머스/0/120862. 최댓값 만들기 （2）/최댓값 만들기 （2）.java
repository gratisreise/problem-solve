class Solution {
    public int solution(int[] numbers) {
        int ret = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i == j) continue;
                ret = Math.max(ret, numbers[i] * numbers[j]);
            }
        }
        return ret;
    }
}