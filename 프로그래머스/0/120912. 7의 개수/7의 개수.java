class Solution {
    public int solution(int[] array) {
        int ret = 0;
        for(int i : array){
            String s = "" + i;
            for(char c : s.toCharArray()){
                if(c == '7') ret++;
            }
        }
        return ret;
    }
}