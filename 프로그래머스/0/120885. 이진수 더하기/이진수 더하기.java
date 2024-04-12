class Solution {
    static String intToBinaray(int n){
        String ans = "";
        while(n > 0){
            ans = ""+ n%2 +ans;
            n /= 2;
        }
        if(ans.length() == 0) return "0";
        return ans;
    }
    static int binaryToInt(String s){
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        String temp = sb.reverse().toString();
        int n2 = 1;
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == '1') ans += n2;
            n2 *= 2;
        }
        return ans;
    }
    public String solution(String bin1, String bin2) {
        String ret = "";
        int sum = binaryToInt(bin1) + binaryToInt(bin2);
        ret = intToBinaray(sum);
        return ret;
    }
}

//2진수 정수변환
//계산
//2진수 변환