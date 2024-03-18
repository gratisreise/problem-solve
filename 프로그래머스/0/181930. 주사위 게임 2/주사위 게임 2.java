class Solution {
    public int solution(int a, int b, int c) {
        int ret = 0;
        if(a != b && b != c && c != a){ //3개 서로달라
            ret = a + b + c;
        }else if(a == b && b == c && c == a){ // 3개 서로같아
            ret = (a + b + c)*(a*a + b*b + c*c)*(a*a*a + b*b*b + c*c*c);
        } else { //2개는 같고 1개는 달라
            ret = (a + b + c) * (a*a + b*b + c*c);
        }
        return ret;
    }
}
//??