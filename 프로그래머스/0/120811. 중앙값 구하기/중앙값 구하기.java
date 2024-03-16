import java.util.*;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int ret = array[array.length / 2];
        return ret;
    }
}