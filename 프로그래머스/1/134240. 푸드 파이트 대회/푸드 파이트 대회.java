class Solution {
    public String solution(int[] food) {
        String ret = "0";
        for(int i = food.length - 1 ; i > 0; i--){
            food[i] -= food[i] % 2;
            if(food[i] == 0) continue;
            for(int j = 0; j < food[i]; j += 2){
                ret = "" + i + ret;
                ret = ret + "" + i;
            }
        }
        return ret;
    }
}