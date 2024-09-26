class Solution {
    private int position(int[] dot){
        int pos = 0;
        if(dot[0] > 0 && dot[1] > 0) pos = 1;
        else if(dot[0] < 0 && dot[1] > 0) pos = 2;
        else if(dot[0] < 0 && dot[1] < 0) pos = 3;
        else pos = 4;
        return pos;
    }
    public int solution(int[] dot) {
        return position(dot);
    }
}