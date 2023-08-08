class Solution {
    public int solution(int n) {
        int ret = 0;
        int temp = n;
        
        while(true){
            temp++;
            if(count(n) == count(temp)) {
                ret = temp; break;
            }
        }
        
        return ret;
    }
    
    public int count(int n){
        int cnt = 0;
        String s = Integer.toBinaryString(n);
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') cnt++;
        }
        
        return cnt;
    }
    
}