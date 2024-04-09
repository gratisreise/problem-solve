class Solution {
    
    public String solution(String s) {
        String ret = "";
        String[] ss = s.split(" ");
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for(String sss : ss){
            int n = Integer.parseInt(sss);
            if(n > mx) mx = n;
            if(n < mn) mn = n;
        }
        ret = ""+mn + " "+ mx;
        
        return ret;
    }
}