class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int temp1 = Integer.parseInt("" + a + b);
        int temp2 = 2 * a * b;
        if(temp1 > temp2) return temp1;
        else if(temp2 > temp1) return temp2;
        else return temp1;
    }
}