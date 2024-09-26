class Solution {
    private boolean check(int n){
        return n == 3 || n == 6 || n == 9;
    }
    public int solution(int order) {
        int ret = 0;
        for(char c : String.valueOf(order).toCharArray()){
            if(check(c - '0')) ret++;
        }
        return ret;
    }
}