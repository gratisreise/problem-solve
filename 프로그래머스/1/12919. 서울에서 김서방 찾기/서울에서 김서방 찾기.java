class Solution {
    public String solution(String[] seoul) {
        String ret = "";
        int idx = 0;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                idx = i;
                break;
            }
        }
        ret = "김서방은 " +idx +"에 있다";
        
        
        return ret;
    }
}