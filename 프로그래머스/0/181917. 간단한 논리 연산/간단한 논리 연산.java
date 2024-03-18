class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean ret = true;
        ret = (x1 || x2) && (x3 || x4);
        
        return ret;
    }
}