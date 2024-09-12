class Solution {
    public int[] solution(long n) {
        String reversed = new StringBuilder(Long.toString(n)).reverse().toString();
        char[] reversedArr = reversed.toCharArray();
        int[] ret = new int[reversedArr.length];
        for(int i = 0; i < ret.length; i++){
            ret[i] = reversedArr[i] - '0';
        }
        return ret;
    }
}
/*

1. 입력받은 숫자를 문자열로 변환한다.
2. 문자열을 뒤집는다
3. 뒤집힌 문자열을 문자의 배열로 변환한다
4. 배열의 각 문자를 정수로 변환한다.
*/