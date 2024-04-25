import java.util.*;
class Solution {
    static class Pair{
        char f; int s;
        Pair(char f, int s){
            this.f = f;
            this.s = s;
        }
    }
    static void calc(Pair[] pArr, char c, int score){
        for(Pair p : pArr){
            if(p.f == c) {
                p.s += score;
                break;
            }
        }
    } 
    public String solution(String[] survey, int[] choices) {
        String ret = "";
        Pair[] pArr = new Pair[8];
        pArr[0] = new Pair('R', 0);
        pArr[1] = new Pair('T', 0);
        pArr[2] = new Pair('C', 0);
        pArr[3] = new Pair('F', 0);
        pArr[4] = new Pair('J', 0);
        pArr[5] = new Pair('M', 0);
        pArr[6] = new Pair('A', 0);
        pArr[7] = new Pair('N', 0);
        
        for(int i = 0; i < survey.length; i++){
            int score = choices[i];
            String s = survey[i];
            if(score < 4) {
                char c = s.charAt(0);
                score = 4 - score;
                calc(pArr, c, score);
            } else if(score > 4){
                char c = s.charAt(1);
                score %= 4;
                calc(pArr, c, score);
            }
        }
        // for(Pair p : pArr){
        //     System.out.println(p.f + "::" + p.s);
        // }
        for(int i = 0; i < 8; i += 2){
            ret += (pArr[i].s >= pArr[i + 1].s) ? pArr[i].f : pArr[i + 1].f;
        }
        return ret;
    }
}