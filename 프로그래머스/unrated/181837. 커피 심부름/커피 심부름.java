class Solution {
    public int solution(String[] order) {
        String s1 = "latte";
        int ame = 0;
        int latte = 0;
        for(String s : order){
            if(s.contains(s1)) latte++;
            else ame++;
        }
        int ret = 0;
        ret = ame*4500 + latte*5000;
        return ret;
    }
}