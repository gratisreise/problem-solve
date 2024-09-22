class Solution {
    public int solution(String[] babbling) {
        int ret = 0;
        for(String s : babbling){
            String temp = s.replaceAll("aya|ye|woo|ma", "");
            // System.out.println(temp);
            if(temp.equals("")) ret++;
        }
        
        return ret;
    }
}