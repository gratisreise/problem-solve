class Solution {
    private static String[] numbers  = {"zero", "one", "two","three","four", "five", "six", "seven", "eight", "nine"};
    public long solution(String number) {
        for(int i = 0; i < 10; i++){
            number = number.replace(numbers[i], String.valueOf(i));
        }
        return Long.parseLong(number);
    }
}