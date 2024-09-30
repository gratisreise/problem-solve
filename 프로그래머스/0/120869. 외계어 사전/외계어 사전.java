class Solution {
    private int[] cnt = new int[26];
    public int solution(String[] spell, String[] dic) {
        int ret = 0;
        for(String s : spell) cnt[s.charAt(0) - 'a']++;
        for(String s : dic){
            int[] temp = new int[26];
            boolean flag = true;
            for(char c : s.toCharArray()) temp[c- 'a']++;
            for(int i = 0; i < 26; i++){
                if(cnt[i] != temp[i]) flag = false;
            }
            if(flag) return 1;
        }
        return 2;
    }
}