class Solution {
    public int[] solution(int brown, int yellow) {
        for(int width = 3; width <= 5000; width++){
            for(int height = 3; height <= width; height++){
                //조건 검사
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;
                if(brown == boundary && yellow == center){
                    return new int[]{width, height};
                }
            }
        }
        return null;
    }
}
/*
규칙찾기
문제를 잘 읽어보고 문제에 해당하는 규칙을 찾기

*/