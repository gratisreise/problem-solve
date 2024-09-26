class Solution {
    private int calculate(String a, String b, String op){
        int ans = 0;
        if(op.equals("+")) ans = Integer.parseInt(a) + Integer.parseInt(b);
        else if(op.equals("-")) ans = Integer.parseInt(a) - Integer.parseInt(b);
        else if(op.equals("*")) ans = Integer.parseInt(a) * Integer.parseInt(b);
        return ans;
    }
    public int solution(String binomial) {
        String[] arr = binomial.split(" ");
        return calculate(arr[0], arr[2], arr[1]);
    }
}