class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        int cnt1[] = new int[26];
        int cnt2[] = new int[26];
        for(char c : before.toCharArray()){
            cnt1[c - 'a']++;
        }
        for(char c : after.toCharArray()){
            cnt2[c - 'a']++;
        }
        for(int i = 0;  i < 26; i++){
            if(cnt1[i] != cnt2[i]) answer = 0;
        }
        return answer;
    }
}