class Solution {
    public long solution(int a, int b) {
        long ret = 0;
        int l, r;
        if(a < b) {l = a; r = b;}
        else {l = b; r = a;}
        for(int i = l; i <= r; i++){
            ret += i;
        }
        
        return ret;
    }
}