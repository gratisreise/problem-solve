class Solution {
    public int[] solution(int money) {
        int a = money / 5500;
        int b = money - 5500 * a;
        int[] answer = {a, b};
        return answer;
    }
}