import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        // arr2[0]이 0일 수 없다 => 길이 2이상
        int col = arr2[0].length;
        int cnt = arr1[0].length;
        int[][] ret = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //각 요소에 맞는 행의 곱하기
                for(int x = 0; x < cnt; x++){
                    ret[i][j] += arr1[i][x] * arr2[x][j];
                }
            }
        }
        return ret;
    }
}

/*
결과 행렬의 행: arr1의행, 열: arr2의 열
1. 결과 행의 크기를 초기화
    1-1. row, col으로 크기를 결정
2. 2중 for문: arr1의 행크기 -> arr2의 열크기
3. 반복하면서 행렬의 요소 채우기


*/