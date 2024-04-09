class Solution {
    public int solution(int i, int j, int k) {
        int ret = 0;
        
        for(int x = i; x <= j; x++){
            String s = "" + x;
            for(char c : s.toCharArray()){
                if((c - '0') == k) ret++;
            }
        }
        
        
        return ret;
    }
}