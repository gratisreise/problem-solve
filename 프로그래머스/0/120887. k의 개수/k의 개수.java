class Solution {
    public int solution(int i, int j, int k) {
        int ret = 0;
        char c = (char)(k + '0');
        for(int x = i; x <= j; x++){
            String temp1 = ""+x;
            for(char cc : temp1.toCharArray()){
                if(cc == c) ret++;
            }
            
        }
        return ret;
    }
}