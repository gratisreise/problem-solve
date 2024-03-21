class Solution {
    public int solution(int n) {
        int ret = 0;
        
        int temp = n;
        //3진법 변환
        String s3 = "";
        while(temp > 0){
            s3 += ("" + temp % 3);
            temp /= 3;
        }
        
        //계산
        for(int i = s3.length() - 1; i >= 0; i--){
            int k = i;
            if(s3.charAt(i) == '0') continue;
            int n3 = 1;
            for(int j = 0; j < s3.length() - 1 -k; j++){
                n3 *= 3;
            }
            ret += (s3.charAt(i) - '0') * n3;
        }
        
        return ret;
    }
}