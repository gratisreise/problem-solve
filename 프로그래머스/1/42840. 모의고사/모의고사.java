import java.util.*;
class Solution {
    public  List<Integer> solution(int[] ans) {
        int[] cnt1 = new int[ans.length];
        int[] cnt2 = new int[ans.length];
        int[] cnt3 = new int[ans.length];
        int[] forCnt2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] forCnt3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < ans.length; i++){
            cnt1[i] = i % 5 + 1;
            cnt2[i] = forCnt2[i % forCnt2.length];
            cnt3[i] = forCnt3[i % forCnt3.length];
            System.out.println(cnt1[i] + "::" + cnt2[i] + "::" + cnt3[i]);
        }
        //각자 개수 세기
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i = 0; i < ans.length; i++){
            if(ans[i] == cnt1[i]) count1++;
            if(ans[i] == cnt2[i]) count2++;
            if(ans[i] == cnt3[i]) count3++;
        }
        int[] countSet = {count1, count2, count3};
        int countMx = -1;
        for(int i : countSet) if(i > countMx) countMx = i;
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < countSet.length; i++){
            if(countSet[i] == countMx) ret.add(i + 1);
        }
        return ret;
        
        
    }
}