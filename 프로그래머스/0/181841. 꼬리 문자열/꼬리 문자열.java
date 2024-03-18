class Solution {
    public String solution(String[] str_list, String ex) {
        String ret = "";
        for(String s : str_list){
            if(s.contains(ex)) continue;
            ret += s;
        }
        
        
        return ret;
    }
}