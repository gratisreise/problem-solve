class Solution {
    public int solution(String s) {
        int ret = 0;
        String[] str = s.split(" ");
        String prev = "0";
        for(String ss : str){
            if(ss.equals("Z")){
              ret -= Integer.parseInt(prev);  
            } else  ret += Integer.parseInt(ss);
            prev = ss;
        }
        return ret;
    }
}