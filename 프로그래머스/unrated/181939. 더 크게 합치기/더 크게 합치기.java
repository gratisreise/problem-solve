class Solution {
    public int solution(int a, int b) {
        int temp1 = Integer.parseInt(""+ a + b);
        int temp2 = Integer.parseInt(""+ b + a);;
        int ret = 0;
        if(temp1 > temp2){
            ret = temp1;
        } else if(temp2 > temp1) {
            ret = temp2;
        } else {
            ret = temp1;
        }
        return ret;
    }
}