class Solution {
    public String solution(String a, String b) {
        String answer = "";
        StringBuilder ret = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int prev = 0;
        for(int i = 0; i < n; i++){
            int aNum = a.length() >= i + 1 ? a.charAt(i) - '0' : 0;
            int bNum = b.length() >= i + 1 ? b.charAt(i) - '0' : 0;
            int sum = aNum + bNum + prev;
            if(sum >= 10) {prev = 1; sum -= 10;}
            else prev = 0;
            ret.append(sum);
        }
        if(prev == 1) ret.append(1);
        return ret.reverse().toString();
    }
}