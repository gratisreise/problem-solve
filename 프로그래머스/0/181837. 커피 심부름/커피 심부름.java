class Solution {
    public int solution(String[] order) {
        int ret = 0;
        for(String s : order){
            ret += s.contains("cafelatte") ? 5000 : 4500;
        }
        return ret;
    }
}