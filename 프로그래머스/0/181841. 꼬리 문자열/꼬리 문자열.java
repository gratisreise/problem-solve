class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder ret = new StringBuilder();
        for(String s : str_list) {
            if(s.indexOf(ex) != -1) continue;
            ret.append(s);
        }
        return ret.toString();
    }
}