class Solution {
    public String solution(String s) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c - 'a']++;
        }
        String ret = "";
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == 1) ret += (char)(i + 'a');
        }
        return ret;
    }
}