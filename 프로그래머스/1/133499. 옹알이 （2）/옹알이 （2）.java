import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int ret = 0;
        List<String> sl = new ArrayList<>();
        sl.add("aya");
        sl.add("ye");
        sl.add("woo");
        sl.add("ma");
        for(String s : babbling){
            String temp = "";
            String prev = "";
            boolean flag = false;
            for(char c : s.toCharArray()){
                temp += c;
                if(sl.contains(temp) && prev.equals(temp)){ 
                    flag = true;
                } else if(sl.contains(temp) && !prev.equals(temp)){
                    prev = temp;
                    temp = "";
                }
                
            }
            if(temp.length() > 0 && !sl.contains(temp)) flag = true;
            if(temp.equals(s)) flag = true;
            if(!flag) ret++;
        }
        return ret;
    }
}