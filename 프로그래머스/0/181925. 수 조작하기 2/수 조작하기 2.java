class Solution {
    private char process(int n){
        return switch(n){
                case 1 -> 'w';
                case -1 -> 's';
                case 10 -> 'd';
                case -10 -> 'a';
                default -> '9';
        };
    }
    private String makeRet(int[] numLog){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < numLog.length; i++){
            sb.append(process(numLog[i] - numLog[i - 1]));   
        }
        return sb.toString();
    }
    public String solution(int[] numLog) {
        return makeRet(numLog);
    }
}