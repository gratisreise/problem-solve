class Solution {
    public int solution(String[] strArr) {
        int ret = 0;
        int[] temp = new int[34];
        for(String s : strArr){
            temp[s.length()]++;
        }
        
        for(int i : temp){
            ret = Math.max(ret, i);
        }
        return ret;
    }
}