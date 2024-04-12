import java.util.*;
class Solution {
    public List<Integer> solution(int n, int[] slicer, int[] num_list) {
        List<Integer> ret = new ArrayList<>();
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        if(n == 1){
            for(int i = 0; i <= b; i++){
                ret.add(num_list[i]);
            }
            return ret;
        } else if(n == 2){
            for(int i = a; i < num_list.length; i++){
                ret.add(num_list[i]);
            }
        } else if(n == 3){
            for(int i = a; i <= b; i++){
                ret.add(num_list[i]);
            }
        } else if(n == 4){
            for(int i = a; i <= b; i += c){
                ret.add(num_list[i]);
            }
        }
        return ret;
    }
}