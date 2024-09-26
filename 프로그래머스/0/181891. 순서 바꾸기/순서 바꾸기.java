import java.util.*;
import java.util.stream.*;
class Solution {
    private void filling(int start, int end, int[] arr, List<Integer> l){
        for(int i = start; i < end; i++){
            l.add(arr[i]);
        }
    }
    public int[] solution(int[] num_list, int n) {
        List<Integer> ret = new ArrayList<>();
        filling(n, num_list.length, num_list, ret);
        filling(0, n, num_list, ret);
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}