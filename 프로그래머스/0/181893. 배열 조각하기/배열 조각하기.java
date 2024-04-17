import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int[] query) {
        List<Integer> ret = new ArrayList<>(); 
        for(int i : arr) ret.add(i);
        
        for(int i = 0; i < query.length; i++){
            List<Integer> temp = new ArrayList<>();
            if(i % 2 == 0){
                for(int j = 0; j <= query[i]; j++){
                    temp.add(ret.get(j));
                }
            } else {
                for(int j = query[i]; j < ret.size(); j++){
                    temp.add(ret.get(j));
                }
            }
            ret = new ArrayList<>(temp);
        }
        return ret;
    }
}