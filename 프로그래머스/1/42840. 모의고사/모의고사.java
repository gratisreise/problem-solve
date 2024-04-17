import java.util.*;
class Solution {
    static List<Integer> l = new ArrayList<>();
    public List<Integer> solution(int[] answers) {
        int n = answers.length;
        int[] cnt = new int[3];
        int max = -1;
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int n1 = num1.length;
        int n2 = num2.length;
        int n3 = num3.length;
        for(int i = 0; i < n; i++){
            if(num1[i % n1] == answers[i]) cnt[0]++;
            if(num2[i % n2] == answers[i]) cnt[1]++;
            if(num3[i % n3] == answers[i]) cnt[2]++;
        }
        for(int i = 0; i < 3; i++) max = Math.max(cnt[i], max);
        for(int i = 0; i < 3; i++) if(cnt[i] == max) l.add(i + 1);
        return l;
    }
}