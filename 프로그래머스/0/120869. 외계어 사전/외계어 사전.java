class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String s : dic){
            boolean flag = true;
            for(String ss : spell){
                if(!s.contains(ss)) flag = false;
            }
            if(flag) return 1;
        }
        return 2;
    }
}