import java.util.*;
class Solution {
    public List<Integer> solution(int[] array, int[][] com) {
        List<Integer> ret = new ArrayList<>();
        String s = "";
        for(int x = 0; x < com.length; x++){
            int i = com[x][0] - 1;
            int j = com[x][1];
            int k = com[x][2] - 1;
            List<Integer> l = new ArrayList<>();
            for(int y = i; y < j; y++) l.add(array[y]);
            Collections.sort(l);
            ret.add(l.get(k));
        }
        return ret;
    }
}