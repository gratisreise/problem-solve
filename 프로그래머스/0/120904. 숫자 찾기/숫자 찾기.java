class Solution {
    public int solution(int num, int k) {
        int ret = -1;
        String temp = "" + num;
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == k + '0') {
                ret = i + 1;
                break;
            }
        }
        
        return ret;
    }
}