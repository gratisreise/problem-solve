class Solution {
    private int lr(String s){
        if(s.equals("left")) return -1;
        else if(s.equals("right")) return 1;
        return 0;
    }
    private int ud(String s){
        if(s.equals("down")) return -1;
        else if(s.equals("up")) return 1;
        return 0;
    }
    public int[] solution(String[] keyinput, int[] board) {
        int n = board[0]/2 == 0 ? 1 : board[0]/2;
        int m = board[1]/2 == 0 ? 1 : board[1]/2;
        int r = 0;
        int u = 0;
        for(String s : keyinput){
            int nr = r + lr(s); 
            int nu = u + ud(s);
            if(Math.abs(nr) > n || Math.abs(nu) > m) continue;
            r = nr;
            u = nu;
        }
        return new int[]{r, u};
    }
}