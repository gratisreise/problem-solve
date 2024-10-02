class Solution {
    private int calculate(String n1, String n2, String oper){
        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        int ret = switch(oper){
                case "+" -> a + b;
                case "-" -> a - b;
                default -> 0;
        };
        return ret;
    }
    public String[] solution(String[] quiz) {
        String[] ret = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] arr = quiz[i].split(" ");
            if(calculate(arr[0], arr[2], arr[1]) == Integer.parseInt(arr[4])) ret[i] = "O";
            else ret[i] = "X";            
        }
        return ret;
    }
}
/*
1. 모든 문자열에 대해
2. 문자열 계산 체크 반복
3. 문자열배열에 저장
*/