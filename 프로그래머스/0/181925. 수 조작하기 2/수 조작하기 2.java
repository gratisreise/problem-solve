class Solution {
    static String oper(int a, int b){
        String ret = "";
        if(a + 1 == b) ret = "w";
        else if(a - 1 == b) ret = "s";
        else if(a + 10 == b) ret = "d";
        else if(a - 10 == b) ret = "a";
        return ret;
    }
    public String solution(int[] numLog) {
        String ret = "";
        for(int i = 0; i <numLog.length - 1; i++){
            ret += oper(numLog[i], numLog[i + 1]);
        }   
        return ret;
    }
}