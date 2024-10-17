import java.util.*;
class Solution {
    private final int[][] mem = new int[501][501];
    
    private int max(int y, int x, int[][] triangle){
        if(y == triangle.length) return 0; // 종료조건
        if(mem[y][x] != -1) return mem[y][x];
        
        return mem[y][x] = triangle[y][x] + 
            Math.max(max(y + 1, x, triangle), max(y + 1, x + 1, triangle));     
    }
    public int solution(int[][] triangle) {
        for(int[] row : mem) Arrays.fill(row, -1);
        return max(0, 0, triangle);
    }
}