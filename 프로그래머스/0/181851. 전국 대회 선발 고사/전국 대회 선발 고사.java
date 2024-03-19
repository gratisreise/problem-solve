import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int ret = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int[] temp = Arrays.copyOf(rank, rank.length);
        Arrays.sort(temp);
        int cnt = 0;
        for(int i = 0; i < temp.length; i++){
            int idx = 0;
            for(int j = 0; j < rank.length; j++){
                if(temp[i] == rank[j]) idx = j;
            }
            if(attendance[idx]){ 
                cnt++;
                if(cnt == 1) a = idx;
                else if(cnt == 2) b = idx;
                else if(cnt == 3) {c = idx; break;}
            }
            
        }
        ret = 10000 * a + 100 * b + c;
        return ret;
    }
}