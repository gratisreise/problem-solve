import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int mx = -1;
        for(int i : array) mx = Math.max(i, mx);
        answer[0] = mx;
        answer[1] = Arrays.binarySearch(array, mx);
        return answer;
    }
}