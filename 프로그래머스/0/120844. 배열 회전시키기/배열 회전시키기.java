class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] ret = new int[numbers.length];
        if(direction.equals("left")){
            for(int i = 0; i < ret.length; i++){
                ret[i] = numbers[(i + 1) % ret.length];
            }
        } else {
            for(int i = 0; i < ret.length; i++){
                ret[i] = numbers[(i + ret.length - 1) % ret.length];
            }
        }
        return ret;
    }
}