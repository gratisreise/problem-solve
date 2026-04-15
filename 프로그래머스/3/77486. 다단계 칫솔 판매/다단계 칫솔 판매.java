import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] ret = new int[n];
        
        // 1. 이름 - 인덱스 매핑 (빠른 접근을 위해)
        Map<String, Integer> mp = new HashMap<>();// 이름 - 인덱스
        for(int i = 0; i < n; i++){
            mp.put(enroll[i], i);
        }

        // 2. 부모 정보 저장 (인덱스로 관리하면 더 빠름)
        // parentIdx[i]는 i번째 사람의 추천인 인덱스. 없으면 -1
        int[] parentIdx = new int[n];
        for(int i = 0; i < n; i++){
            if(referral[i].equals("-")){
                parentIdx[i] = -1;
            } else {
                parentIdx[i] = mp.get(referral[i]);
            }
        }

        // 3. 판매 기록 순회
        for(int i = 0; i < seller.length; i++){
            int cur = mp.get(seller[i]);
            int money = amount[i] * 100;
            
            // 부모가 올라가면서 수익분배
            while(cur != -1 && money > 0){
                int tax = money / 10;
                int myProfit = money - tax;
                
                ret[cur] += myProfit;
                
                money = tax;
                cur = parentIdx[cur];
            }
        }

        return ret;
    }
}