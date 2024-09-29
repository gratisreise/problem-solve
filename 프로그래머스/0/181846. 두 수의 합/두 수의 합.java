class Solution {
    public String solution(String a, String b) {
        int n = Math.max(a.length(), b.length());
        char[] arr = new StringBuilder(a).reverse().toString().toCharArray();
        char[] brr = new StringBuilder(b).reverse().toString().toCharArray();
        int prev = 0;
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < n; i++){
            int aNum = i + 1 > arr.length ? 0 : arr[i] - '0';
            int bNum = i + 1 > brr.length ? 0 : brr[i] - '0';
            int sum = aNum + bNum + prev;
            prev = 0;
            if(sum >= 10){prev = 1; sum -= 10;}
            ret.append(sum);
        }
        if(prev == 1) ret.append(1);
        return ret.reverse().toString();
    }
}