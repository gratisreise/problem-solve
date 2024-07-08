class Solution {
    
    public String solution(String X, String Y) {
        
        String answer = "";
        int[] cntx = new int[10];
        int[] cnty = new int[10];
        for(char c : X.toCharArray()) cntx[c - '0']++;
        for(char c : Y.toCharArray()) cnty[c - '0']++;
        int[] cnt = new int[10];
        for(int i = 0; i < 10; i++) cnt[i] = Math.min(cntx[i], cnty[i]);
        
        StringBuilder temp = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            if(i == 0 && temp.length() == 0 && cnt[i] > 0) temp.append(0);
            else {
                for(int j = 0; j < cnt[i]; j++) temp.append(i);
            }
        }
        
        if(temp.length() == 0) answer = "-1";
        else answer = temp.toString();
        return answer;
    }
}