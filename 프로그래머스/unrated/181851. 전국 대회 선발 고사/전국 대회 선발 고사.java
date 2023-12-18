import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> rank1 = new ArrayList<>();
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]) rank1.add(rank[i]);
        }
        for(int i : rank1) System.out.print(i + " ");
        Collections.sort(rank1);
        int a = -1;
        int b = -1;
        int c = -1;
        for(int i = 0; i < rank.length; i++){
            if(rank[i] == rank1.get(0)) a = i;
            else if(rank[i] == rank1.get(1)) b = i;
            else if(rank[i] == rank1.get(2)) c = i;
            
            if(a >= 0 && b >= 0 && c >= 0) break;
        }
        
        int ret = 10000 * a + 100 * b + c;
        return ret;
    }
}