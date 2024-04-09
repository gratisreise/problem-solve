class Solution{
    public int solution(int n, int a, int b){
        int ret = 0;
        while(true){
            if(a % 2 == 0) a /= 2;
            else a = (a / 2) + 1;
            if(b % 2 == 0) b /= 2;
            else b = (b / 2) + 1;
            ret++;
            if(a == b) break;
        }
        
        
        return ret;
    }
}