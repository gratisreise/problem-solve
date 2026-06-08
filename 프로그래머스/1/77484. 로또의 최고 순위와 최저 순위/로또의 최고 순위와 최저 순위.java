class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] ret = new int[2];
        int[] rank = {6, 5, 4, 3, 2, 1, 0};
        int[] cnt = new int[46];
        int blank = 0;
        int mn = 0;
        for(int i : win_nums) cnt[i]++;
        for(int i : lottos){
           if(i == 0) {blank++; continue;} 
            for(int j = 1; j <= 45; j++){
                if(cnt[j] == 1 && i == j){
                    mn++;
                }
            }
        }
        int mx = mn + blank;
        for(int i = 0; i < rank.length; i++){
            if(mx == rank[i]) ret[0] = (i+1)>= 6 ? 6 : (i+1);
            if(mn == rank[i]) ret[1] = (i+1)>= 6 ? 6 : (i+1);
            if(ret[0] != 0 && ret[1] != 0) break;
        }
        return ret;
    }
}


/*
1.당첨 가능했던 최고, 최저
2. 순서상관없이 숫자 있으면 맞힌것
3.
*/