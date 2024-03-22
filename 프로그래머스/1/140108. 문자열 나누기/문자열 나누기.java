class Solution {
    public int solution(String s) {
        int ret = 0;
        char std = s.charAt(0);
        int cntStd = 0;
        int cntAnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(std == s.charAt(i)) cntStd++;
            else cntAnt++;
            System.out.println(cntStd + " :: " +cntAnt);
            if(cntStd == cntAnt){
                cntStd = 0;
                cntAnt = 0;
                ret++;
                if(i < s.length() - 1){
                    std = s.charAt(i+1);
                }
            }
            
        }
        if(cntStd > 0 || cntAnt > 0) ret++;
        
        
        return ret;
    }
}