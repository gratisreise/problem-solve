class Solution {
    public int solution(String my_string) {
        int ret = 0;
        
        for(Character c : my_string.toCharArray()){
            if(c < 65) ret += (c - '0');
        }
        
        return ret;
    }
}