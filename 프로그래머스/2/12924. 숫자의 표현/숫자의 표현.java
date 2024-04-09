class Solution {
    static int s = 1, e = 0;
    public int solution(int n) {
        int ret = 0;
        int[] a = new int[n];
        // int k = 10;
        int sum = 0;
        while(e != n){
            // System.out.println(s + " :: " + e);
            if(sum < n) sum += s++;
            else if(sum > n) sum -= e++;
            if(sum == n) { ret++; sum += s++;}
        }
        return ret;
    }
}