import java.util.*;
class Solution {
    
    static Map<Character, Integer> mp = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        String ret = "";
        String[] temp1 = {"RT", "CF", "JM", "AN"};
        for(String s : temp1) {
            for(char c : s.toCharArray()){
                mp.put(c, 0);
            }
        }
        
        for(int i = 0; i < survey.length; i++){
            char c0 = survey[i].charAt(0);
            char c1 = survey[i].charAt(1);
            if(choices[i] < 4){ //순서가 다르다?
                mp.put(c0, mp.get(c0) + (4 - choices[i]));
            } else if(choices[i] > 4){
                mp.put(c1, mp.get(c1) + (choices[i] - 4));
            }
        }
        
        for(Character c : mp.keySet()){
            System.out.println(c + " :: "+ mp.get(c));
        }
        for(String s : temp1){
            char c0 = s.charAt(0);
            char c1 = s.charAt(1);
            if(mp.get(c0) >= mp.get(c1)) ret += c0;
            else ret += c1;
        }
        return ret;
    }
}
// char : int 맵에서 해당하는 문자에 따라 넣어주기
// temp1을 순회하면서 map의 숫자를 순회