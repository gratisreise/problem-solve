class Solution {
    public int solution(String[] s1, String[] s2) {
        int ret = 0;
        for(String s : s1){
            for(String ss : s2){
                if(s.equals(ss)) ret++;
            }
        }
        return ret;
    }
}