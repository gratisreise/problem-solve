class Solution {
    private static class Count{
        public final int zero;
        public final int one;
        
        public Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
        public Count add(Count other){
            return new Count(zero + other.zero, one + other.one);
        }
    }
    private Count count(int offsetX, int offsetY, int size, int[][] arr){
        int h = size / 2;
        for(int x = offsetX; x < offsetX + size; x++){
            for(int y = offsetY; y < offsetY + size; y++){
                if(arr[y][x] != arr[offsetY][offsetX]){
                    /*원소가 섞여있는 경우 반환값*/
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                        
                }
            }
        }
        //모든 원소가 같은 값인 경우
        if(arr[offsetY][offsetX] == 1){
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }
    
}
/*
상태
(offseX, offsetY, size) = 좌표 (offsetX, offsetY)에서 시작하여 가로 길이와 세로 길이가 size인
정사각형을 압축했을 때 남아 있는 0과 1의 개수3
종료조건
범위 안의 모든 원소가 0또는 1 {0:zero, 1:one} 0개수 : 1개수
{0:1, 1:0} -> 모든 원소 0
{0:0, 1:1} -> 모든 원소 1
점화식
(offsetX, offsetY, size) = (offsetX, offsetY, size/2)
                        + (offsetX + size/2, offsetY, size/2)
                        + (offsetX , offsetY + size/2, size/2)
                        + (offsetX + size/2, offsetY + size/2, size/2)
                        
*/