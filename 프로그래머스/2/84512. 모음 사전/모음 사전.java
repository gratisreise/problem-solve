import java.util.*;
class Solution {
    private char[] spells = {'A', 'E', 'I', 'O', 'U'};
    private List<String> words = new ArrayList<>();
    private void word(StringBuilder curS){
        if(curS.length() == 5) return;
        
        for(int i = 0; i < spells.length; i++){
            StringBuilder builder = new StringBuilder(curS);
            words.add(builder.append(spells[i]).toString());
            word(builder);
        }
    }
    public int solution(String word) {
        word(new StringBuilder());
        return words.indexOf(word) + 1;
    }
    
}
/*
상태
(curs, cnt, targetS)

*/