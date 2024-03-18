class Solution {
    public String solution(String my_string, int[] indices) {
        String ret = "";
        for(int i = 0; i < my_string.length(); i++){
            boolean flag = false;
            for(int j : indices){
                if(i == j) flag = true;
            }
            if(!flag) ret += my_string.charAt(i);
        }
        
        return ret;
    }
}