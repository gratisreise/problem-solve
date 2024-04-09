import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> l = new ArrayList<>();
        int mn = (int)1e9;
        int mnIdx = 0;
        for(int i = 0; i < arr.length; i++){
            l.add(arr[i]);
            if(arr[i] < mn){
                mn = arr[i];
                mnIdx = i;
            }
        }
        l.remove(mnIdx);
        return l;
    }
}