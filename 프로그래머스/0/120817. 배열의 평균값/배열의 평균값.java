class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int i : numbers) answer += i;
        double size = numbers.length;
        answer /= size;
        return answer;
    }
}