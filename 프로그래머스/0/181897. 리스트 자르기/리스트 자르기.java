import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int s = 0;
        int e = 0;
        int len = 1;
        if(n == 1){
            s = 0; e = slicer[1];
        } else if(n == 2){
            s = slicer[0]; e = num_list.length - 1;
        } else if(n == 3){
            s = slicer[0]; e = slicer[1];
        } else if(n == 4){
            s = slicer[0]; e = slicer[1]; len = slicer[2];
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = s; i <= e; i += len) ret.add(num_list[i]);
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
시작, 끝, 간격
s, e, len
*/