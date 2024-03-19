class Solution {
    public int solution(String[] spell, String[] dic) {
        int ret = 2;
        int[] cnt1 = new int[26];
        for(String s : spell) cnt1[s.charAt(0)-'a']++;
        for(String s : dic){
            int[] cnt2 = new int[26]; // 새로선언
            for(char c : s.toCharArray()){ // cnt2채우기
                cnt2[c-'a']++;
            }
            boolean flag = false;
            for(int i = 0; i < 26; i++){
                if(cnt1[i] != cnt2[i]) flag = true;
            }
            if(!flag) ret = 1;    
        }    
            
        return ret;
    }
}