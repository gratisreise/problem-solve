class Solution {
    public String solution(String my_string, String alp) {
        String ret = "";
        for(char c : my_string.toCharArray()){
            if(alp.equals((c+""))) ret += (char)(c - 32);
            else ret += c;
        }
        
        return ret;
    }
}