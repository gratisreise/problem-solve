import java.util.*;

class Solution {
    public long solution(String numbers) {
        String ret = "";
        List<String> S = new ArrayList<>();
        String[] cnt = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String temp = "";
        for(char c : numbers.toCharArray()){
            temp += c;
            if(temp.length() >= 3){
                boolean flag = false;
                for(int i = 0; i < cnt.length; i++){
                    if(temp.equals(cnt[i])){
                        ret += (char)(i + '0');
                        flag = true;
                    }
                }
                if(flag) temp = "";
            }
        }
        
        return Long.parseLong(ret);
    }
}