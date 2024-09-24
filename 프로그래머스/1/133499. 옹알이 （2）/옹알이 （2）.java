class Solution {
    String[] arr = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s : babbling){
            String temp = s;
            for(String ss : arr){
                temp = temp.replaceAll("(?<!"+ ss +")"+"("+ ss + ")" +"(?!" + ss + ")", " ");
            }
            temp = temp.replaceAll(" ", "");
            System.out.println(temp);
            if(temp.equals("")) answer++;
        }
        
        return answer;
    }
}
/*
같은 발음이 연속되지 않고 

*/