class Solution {
    public int[] solution(String s) {
        int[] ret = new int[2];
        String temp = s;
        int cnt = 0;
        while(true){
            //x의 모든 0제거
            int cnt1 = 0; // 0제거개수
            int n = 0; //문자열길이
            for(char c : temp.toCharArray()){
                if(c == '1') n++;
                else cnt1++;
            }
            ret[1] += cnt1; // 제거된 0의 갯수 +
            temp = ""; // temp 빈문자열해주기
            //x의길이를 -> 2진수문자열로변환 -> temp에 넣기
            while(n > 0){
                temp = "" + n % 2 + temp;
                n /= 2;
            }
            ret[0]++;
            System.out.println(temp + " :: "+ ret[1]);
            if(temp.equals("1")) break;
        }
        return ret;
    }
}


//x의 길이를 -> 2진수문자열