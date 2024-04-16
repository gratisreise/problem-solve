class Solution {
    static int stringToInt(String s){
        
        return switch(s){
                case "zero" -> 0;
                case "one" -> 1;
                case "two" -> 2;
                case "three" -> 3;
                case "four" -> 4;
                case "five" -> 5;
                case "six" -> 6;
                case "seven" -> 7;
                case "eight" -> 8;
                case "nine" -> 9;
                default -> 10;
        };
    }
    public int solution(String s) {
        int ret = 0;
        String temp = "";
        String ans = "";
        for(char c : s.toCharArray()){
            if('0' <= c && c <= '9') ans +=c;
            else temp += c;
            // System.out.println(temp);
            if(temp.length() >= 3){
                if(stringToInt(temp) == 10) continue;
                else {
                    ans += "" + stringToInt(temp);
                    temp = "";
                }
            }
        }
        ret = Integer.parseInt(ans);
        return ret;
    }
}