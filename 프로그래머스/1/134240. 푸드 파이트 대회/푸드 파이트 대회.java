class Solution {
    public String solution(int[] food) {
        String ret = "";
        ret += "0";
        for(int i = food.length - 1; i >= 1; i--){
            int k = (food[i] / 2);
            String temp = "" + i;
            for(int j = 0; j < k; j++){
                ret = temp + ret;
                ret += temp;
            } 
        }
        return ret;
    }
}