class Solution {
    public String solution(int[] numLog) {
        String ret = "";
        for(int i = 1; i < numLog.length; i++){
            if(numLog[i - 1] + 1 == numLog[i]) ret += "w";
            else if(numLog[i - 1] - 1 == numLog[i]) ret += "s";
            else if(numLog[i - 1] + 10 == numLog[i]) ret += "d";
            else if(numLog[i - 1] - 10 == numLog[i]) ret += "a";
        }
        return ret;
    }
}