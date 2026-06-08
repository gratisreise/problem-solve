import java.util.*;
class Solution {
    static int[] cnt = new int[150];
    public List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> ret = new ArrayList<>();
        Arrays.fill(cnt, 1000);
        for(String s : keymap){
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(cnt[c] > i + 1) cnt[c] = i + 1;
            }
        }
        for(String s : targets){
            int temp = 0;
            boolean flag = false;
            for(char c : s.toCharArray()){
                if(cnt[c] == 1000) {
                    flag = true; break;
                }
                temp += cnt[c];
            }
            if(flag){
                ret.add(-1); continue;
            }
            ret.add(temp);
        }
        
        return ret;
    }
}